package com.weekendesk.anki.domain;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {}

    public Deck(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

}
