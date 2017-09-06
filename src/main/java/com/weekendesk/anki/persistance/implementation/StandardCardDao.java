package com.weekendesk.anki.persistance.implementation;

import com.weekendesk.anki.data.ProcessingStatus;
import com.weekendesk.anki.persistance.CardDao;
import com.weekendesk.anki.util.ProcessingStatusMapper;
import java.io.*;


public class StandardCardDao implements CardDao {

    private static final String FILE_NAME = "cards.json";


    @Override
    public ProcessingStatus find() {

        String jsonProcessingStatus = null;
        StringBuilder fileContent = new StringBuilder();
        InputStream file;

        try {
            file = new FileInputStream(FILE_NAME);
        } catch (FileNotFoundException e) {
            return null;
        }

        if (null != file) {
            InputStreamReader fileReader = new InputStreamReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            try {
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(bufferedReader);
                    fileContent.append(line);
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            jsonProcessingStatus = fileContent.toString();
        }

        return ProcessingStatusMapper.toProcessingStatus(jsonProcessingStatus);
    }

    @Override
    public void save(ProcessingStatus processingStatus) {

        final File file = new File(FILE_NAME);
        String jsonProcessingStatus = ProcessingStatusMapper.toJson(processingStatus);

        try {
            file.createNewFile();
            final FileWriter writer = new FileWriter(file);

            try {
                writer.write(jsonProcessingStatus);
            } finally {
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Error during backup");
        }

    }
}
