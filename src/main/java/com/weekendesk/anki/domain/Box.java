package com.weekendesk.anki.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Box {

    public Box() {}

    public Box(BoxColor color, LocalDateTime changeDate, List<Card> cards) {
        this.color = color;
        this.changeDate = changeDate;
        this.cards = cards;
    }

    private BoxColor color;
    private LocalDateTime changeDate;
    private List<Card> cards;

    public enum BoxColor {
        RED,
        ORANGE,
        GREEN
    }

    public Box(BoxColor color) {
        this.color = color;
        this.cards = new ArrayList<>();
    }

    public BoxColor getColor() {
        return color;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

}
