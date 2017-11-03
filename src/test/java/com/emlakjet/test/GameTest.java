package com.emlakjet.test;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GameTest {

    @Test
    public void game_initialize_shouldInitializeWith10OpenFrames() {
        Game game = new Game();
        List<Frame> frames = game.getFrames();
        List<Frame> openFrames = frames.stream().filter(frame -> frame.isOpen()).collect(Collectors.toList());

        Assert.assertEquals(10, frames.size());
        Assert.assertEquals(10, openFrames.size());
    }

    @Test
    public void game_rollOnce_shouldNotTransitionToNextFrame() {
        Game game = new Game();
        Frame firstFrame = game.getFrames().get(0);

        game.roll(1);

        Frame currentFrame = game.getCurrentFrame();

        Assert.assertTrue(firstFrame.isOpen());
        Assert.assertEquals(firstFrame, currentFrame);
    }

    @Test
    public void game_rollTwice_shouldCloseFirstFrame() {
        Game game = new Game();
        Frame firstFrame = game.getFrames().get(0);

        game.roll(1);
        game.roll(2);

        Frame currentFrame = game.getCurrentFrame();

        Assert.assertFalse(firstFrame.isOpen());
        Assert.assertNotEquals(firstFrame, currentFrame);
    }

    @Test
    public void game_rollStrike_shouldTransitionToNextFrame() {
        Game game = new Game();
        Frame firstFrame = game.getFrames().get(0);

        game.roll(10);

        Frame currentFrame = game.getCurrentFrame();

        Assert.assertTrue(firstFrame.isOpen());
        Assert.assertTrue(firstFrame.isStrike());
        Assert.assertNotEquals(firstFrame, currentFrame);
    }
}
