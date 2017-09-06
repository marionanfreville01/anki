package com.weekendesk.anki.data;

import com.weekendesk.anki.domain.Box;
import com.weekendesk.anki.domain.Deck;

public class ProcessingStatus {

    private Deck deck;
    private Box redBox;
    private Box orangeBox;
    private Box greenBox;

    public ProcessingStatus(){}

    public ProcessingStatus(Deck deck, Box redBox, Box orangeBox, Box greenBox) {
        this.deck = deck;
        this.redBox = redBox;
        this.orangeBox = orangeBox;
        this.greenBox = greenBox;
    }

    public Deck getDeck() {
        return deck;
    }

    public Box getRedBox() {
        return redBox;
    }

    public Box getOrangeBox() {
        return orangeBox;
    }

    public Box getGreenBox() {
        return greenBox;
    }

}
