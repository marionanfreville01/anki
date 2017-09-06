package com.weekendesk.anki.util;

import com.weekendesk.anki.data.ProcessingStatus;
import com.weekendesk.anki.domain.Box;
import com.weekendesk.anki.domain.Card;
import com.weekendesk.anki.domain.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProcessingStatusMapperTest {

    @Test
    public void test_toJson() {

        // Given
        Deck deck = buildDeck();
        Box redBox = new Box(Box.BoxColor.RED);
        Box orangeBox = new Box(Box.BoxColor.ORANGE);
        Box greenBox = new Box(Box.BoxColor.GREEN);
        ProcessingStatus processingStatus = new ProcessingStatus(deck, redBox, orangeBox, greenBox);

        // When
        String result = ProcessingStatusMapper.toJson(processingStatus);

        //Then
        String expected =
        "{" +
            "\"deck\":" + "{" +
                "\"cards\":" +
                    "[" +
                        "{\"question\":\"Question 1\",\"answer\":\"Answer 1\"}," +
                        "{\"question\":\"Question 2\",\"answer\":\"Answer 2\"}," +
                        "{\"question\":\"Question 3\",\"answer\":\"Answer 3\"}" +
                    "]" +
                "}," +
            "\"redBox\":" +
                "{" +
                    "\"color\":\"RED\"," +
                    "\"changeDate\":null," +
                    "\"cards\":[]" +
                "}," +
            "\"orangeBox\":" +
                "{" +
                    "\"color\":\"ORANGE\"," +
                    "\"changeDate\":null," +
                    "\"cards\":[]" +
                "}," +
            "\"greenBox\":" +
                "{" +
                    "\"color\":\"GREEN\"," +
                    "\"changeDate\":null," +
                    "\"cards\":[]" +
            "}" +
        "}";
        Assert.assertEquals(expected, result);

    }

    @Test
    public void test_toProcessingStatus() {

        // Given
        String jsonProcessingStatus =
                "{" +
                        "\"deck\":" + "{" +
                        "\"cards\":" +
                        "[" +
                        "{\"question\":\"Question 1\",\"answer\":\"Answer 1\"}," +
                        "{\"question\":\"Question 2\",\"answer\":\"Answer 2\"}," +
                        "{\"question\":\"Question 3\",\"answer\":\"Answer 3\"}" +
                        "]" +
                        "}," +
                        "\"redBox\":" +
                        "{" +
                        "\"color\":\"RED\"," +
                        "\"changeDate\":null," +
                        "\"cards\":[]" +
                        "}," +
                        "\"orangeBox\":" +
                        "{" +
                        "\"color\":\"ORANGE\"," +
                        "\"changeDate\":null," +
                        "\"cards\":[]" +
                        "}," +
                        "\"greenBox\":" +
                        "{" +
                        "\"color\":\"GREEN\"," +
                        "\"changeDate\":null," +
                        "\"cards\":[]" +
                        "}" +
                        "}";

        // When
        ProcessingStatus processingStatus = ProcessingStatusMapper.toProcessingStatus(jsonProcessingStatus);

        // Then
        Assert.assertEquals(buildProcessingStatus(), processingStatus);

    }

    private static ProcessingStatus buildProcessingStatus() {
        Deck deck = buildDeck();
        Box redBox = new Box(Box.BoxColor.RED);
        Box orangeBox = new Box(Box.BoxColor.ORANGE);
        Box greenBox = new Box(Box.BoxColor.GREEN);
        return new ProcessingStatus(deck, redBox, orangeBox, greenBox);
    }

    private static Deck buildDeck() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Question 1", "Answer 1"));
        cards.add(new Card("Question 2", "Answer 2"));
        cards.add(new Card("Question 3", "Answer 3"));
        return new Deck(cards);
    }

}
