package com.emlakjet.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FrameTest {

    @Test
    public void frame_rollOnce_shouldStayOpen() {
        Frame frame = new Frame();
        frame.roll(1);

        Assert.assertTrue(frame.isOpen());
    }

    @Test
    public void frame_rollTwice_shouldBecomeClosed() {
        Frame frame = new Frame();
        frame.roll(1);
        frame.roll(2);

        Assert.assertFalse(frame.isOpen());
        Assert.assertEquals(3, frame.getScore());
    }

    @Test(expected = InvalidRollException.class)
    public void frame_rollThreeTimes_shouldThrowError() {
        Frame frame = new Frame();
        frame.roll(1);
        frame.roll(2);
        frame.roll(3);
    }

    @Test
    public void frame_rollStrike_shouldStayOpen() {
        Frame frame = new Frame();
        frame.roll(10);

        Assert.assertTrue(frame.isOpen());
    }

    @Test(expected = InvalidRollException.class)
    public void frame_rollAfterStrike_shouldThrowError() {
        Frame frame = new Frame();
        frame.roll(10);
        frame.roll(1);
    }

    @Test
    public void frame_rollTwiceToSpare_shouldStayOpen() {
        Frame frame = new Frame();
        frame.roll(5);
        frame.roll(5);

        Assert.assertTrue(frame.isOpen());
    }

    @Test(expected = InvalidRollException.class)
    public void frame_rollAfterSpare_shouldThrowError() {
        Frame frame = new Frame();
        frame.roll(5);
        frame.roll(5);
        frame.roll(1);
    }
}
