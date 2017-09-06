package com.weekendesk.anki.persistance;

import com.weekendesk.anki.data.ProcessingStatus;


public interface CardDao {

    ProcessingStatus find();

    void save(ProcessingStatus processingStatus);

}
