package com.weekendesk.anki.domain;


import com.weekendesk.anki.data.ProcessingStatus;

import java.util.Iterator;
import java.util.List;

public class Student {

    public boolean hasAnyAnswer() {
        return Math.random() < 0.5;
    }

    public boolean hasAPartOfAnswer() {
        return Math.random() < 0.5;
    }

    public boolean hasAnswer() {
        return Math.random() < 0.5;
    }

    public void studies(Card card, ProcessingStatus ProcessingStatus) {

        if (hasAnyAnswer()) {
            ProcessingStatus.getRedBox().addCard(card);
        }
        else if (hasAPartOfAnswer()) {
            ProcessingStatus.getOrangeBox().addCard(card);
        }
        else if (hasAnswer()) {
            ProcessingStatus.getGreenBox().addCard(card);
        }

    }

    public void studies(List<Card> cards, ProcessingStatus ProcessingStatus) {

        for (Iterator<Card> i = cards.iterator(); i.hasNext();) {
            Card card = i.next();
            studies(card, ProcessingStatus);
            cards.remove(card);
        }

    }

    public void move(Box fromBox, Box toBox) {
        toBox.addCards(fromBox.getCards());
    }

}
