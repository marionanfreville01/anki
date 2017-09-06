package com.weekendesk.anki.persistance.implementation;

import com.weekendesk.anki.data.ProcessingStatus;
import com.weekendesk.anki.domain.Box;
import com.weekendesk.anki.domain.Card;
import com.weekendesk.anki.domain.Deck;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StandardCardDaoTest {

    private StandardCardDao cardDao = new StandardCardDao();


    @Test
    public void test_save() {

        // Given
        Deck deck = buildDeck();
        Box redBox = new Box(Box.BoxColor.RED);
        Box orangeBox = new Box(Box.BoxColor.ORANGE);
        Box greenBox = new Box(Box.BoxColor.GREEN);
        ProcessingStatus processingStatus = new ProcessingStatus(deck, redBox, orangeBox, greenBox);

        // When
        cardDao.save(processingStatus);

        // Then


    }

    private static Deck buildDeck() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Question 1", "Answer 1"));
        cards.add(new Card("Question 2", "Answer 2"));
        cards.add(new Card("Question 3", "Answer 3"));
        return new Deck(cards);
    }

}
