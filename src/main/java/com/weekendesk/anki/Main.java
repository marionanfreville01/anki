package com.weekendesk.anki;

import com.weekendesk.anki.data.ProcessingStatus;
import com.weekendesk.anki.domain.*;


public final class Main {

    public void memorize(Deck deck) {

        Student student = new Student();
        int deckSize = deck.getCards().size();
        Box redBox = new Box(Box.BoxColor.RED);
        Box orangeBox = new Box(Box.BoxColor.ORANGE);
        Box greenBox = new Box(Box.BoxColor.GREEN);

        ProcessingStatus ProcessingStatus = new ProcessingStatus(deck, redBox, orangeBox, greenBox);

        while (ProcessingStatus.getGreenBox().getCards().size() < deckSize) {
            launchSession(ProcessingStatus, student);
        }

        System.out.println("Congratulation !");

    }

    public void launchSession(ProcessingStatus ProcessingStatus, Student student) {

        // TODO read json file

        // first iteration on cards of deck
        if (! ProcessingStatus.getDeck().getCards().isEmpty()) {
            student.studies(ProcessingStatus.getDeck().getCards(), ProcessingStatus);
        }
        else {
            student.studies(ProcessingStatus.getOrangeBox().getCards(), ProcessingStatus);
        }

        // studies red box cards
        while (! ProcessingStatus.getRedBox().getCards().isEmpty()) {
            student.studies(ProcessingStatus.getRedBox().getCards(), ProcessingStatus);
        }

        // Move cards of the orange box and put them in the red box, and the cards from the green box in the orange.
        student.move(ProcessingStatus.getOrangeBox(), ProcessingStatus.getRedBox());
        student.move(ProcessingStatus.getGreenBox(), ProcessingStatus.getOrangeBox());

        // end of ProcessingStatus

        // TODO write json file

    }

}
