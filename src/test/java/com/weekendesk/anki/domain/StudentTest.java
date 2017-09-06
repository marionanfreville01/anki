package com.weekendesk.anki.domain;

import com.weekendesk.anki.data.ProcessingStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class StudentTest {

    private Student student = new Student();


    @Test
    public void test_studies() {

        // Given
        Card card = new Card("Question 1", "Answer 1");
        Deck deck = buildDeck();
        Box redBox = new Box(Box.BoxColor.RED);
        Box orangeBox = new Box(Box.BoxColor.ORANGE);
        Box greenBox = new Box(Box.BoxColor.GREEN);
        ProcessingStatus ProcessingStatus = new ProcessingStatus(deck, redBox, orangeBox, greenBox);

        // When
        student.studies(card, ProcessingStatus);

        // Then
        Assert.assertTrue(hasAddedCardInBox(ProcessingStatus));
    }

    private boolean hasAddedCardInBox(ProcessingStatus ProcessingStatus) {
        return ProcessingStatus.getRedBox().getCards().size() > 0 ||
               ProcessingStatus.getOrangeBox().getCards().size() > 0 ||
               ProcessingStatus.getGreenBox().getCards().size() > 0;
    }

    private static Deck buildDeck() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Question 1", "Answer 1"));
        cards.add(new Card("Question 2", "Answer 2"));
        cards.add(new Card("Question 3", "Answer 3"));
        return new Deck(cards);
    }

}
