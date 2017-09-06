package com.weekendesk.anki.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weekendesk.anki.data.ProcessingStatus;
import java.io.IOException;


public class ProcessingStatusMapper {

    public static String toJson(ProcessingStatus processingStatus) {

        String jsonProcessingStatus = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            jsonProcessingStatus = mapper.writeValueAsString(processingStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonProcessingStatus;

    }

    public static ProcessingStatus toProcessingStatus(String jsonProcessingStatus) {

        ProcessingStatus processingStatus = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            TypeReference<ProcessingStatus> mapType = new TypeReference<ProcessingStatus>() {};
            processingStatus = mapper.readValue(jsonProcessingStatus, mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return processingStatus;

    }

}
