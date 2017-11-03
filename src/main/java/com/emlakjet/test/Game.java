package com.emlakjet.test;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames;

    private int currentFrameIndex = 0;

    public Game() {
        frames = new ArrayList<Frame>();

        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public Frame getCurrentFrame() {
        return frames.get(currentFrameIndex);
    }

    public void roll(int i) {
        Frame currentFrame = getCurrentFrame();
        currentFrame.roll(i);

        if (!currentFrame.isOpen() || currentFrame.isStrike()) {
            currentFrameIndex++;
        }
    }

}
