package com.weekendesk.anki.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class BoxTest {

    @Test
    public void test_create_new_box() {

        // When
        Box box = new Box(Box.BoxColor.GREEN);

        // Then
        Assert.assertEquals(Box.BoxColor.GREEN, box.getColor());
        Assert.assertEquals(Collections.emptyList(), box.getCards());
        Assert.assertNull(box.getChangeDate());

    }

    @Test
    public void test_addCard() {

        // Given
        Box box = new Box(Box.BoxColor.GREEN);
        Card card = new Card("My question", "My answer");

        // When
        box.addCard(card);

        // Then
        Assert.assertNotNull(box.getCards());
        Assert.assertEquals(1, box.getCards().size());
        Assert.assertEquals("My question", box.getCards().get(0).getQuestion());
        Assert.assertEquals("My answer", box.getCards().get(0).getAnswer());

    }

}
