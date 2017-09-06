package com.weekendesk.anki;

import com.weekendesk.anki.data.ProcessingStatus;
import com.weekendesk.anki.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MainTest {

    private Main main = new Main();


    @Test
    public void test_launchSession() {

        // Given
        Student student = new Student();
        Deck deck = buildDeck();
        Box redBox = new Box(Box.BoxColor.RED);
        Box orangeBox = new Box(Box.BoxColor.ORANGE);
        Box greenBox = new Box(Box.BoxColor.GREEN);
        ProcessingStatus ProcessingStatus = new ProcessingStatus(deck, redBox, orangeBox, greenBox);

        // When
        main.launchSession(ProcessingStatus, student);

        // Then
        Assert.assertTrue(ProcessingStatus.getDeck().getCards().isEmpty());
        Assert.assertTrue(ProcessingStatus.getRedBox().getCards().isEmpty());
        // all cards are moved in orange or green box
        List<Card> cardsFromOrangeAndGreenBox = new ArrayList<>();
        cardsFromOrangeAndGreenBox.addAll(ProcessingStatus.getOrangeBox().getCards());
        cardsFromOrangeAndGreenBox.addAll(ProcessingStatus.getGreenBox().getCards());
        Assert.assertEquals(3, cardsFromOrangeAndGreenBox.size());

    }

    private static Deck buildDeck() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Question 1", "Answer 1"));
        cards.add(new Card("Question 2", "Answer 2"));
        cards.add(new Card("Question 3", "Answer 3"));
        return new Deck(cards);
    }

}
