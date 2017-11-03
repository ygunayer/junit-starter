package com.emlakjet.test;

public class Frame {

    private int score = 0;

    private int totalRolls = 0;

    private boolean isStrike = false;

    private boolean isSpare = false;

    public void roll(int i) {
        if (!isOpen()) {
            throw new InvalidRollException();
        }

        if (isStrike) {
            throw new InvalidRollException();
        }

        if (isSpare) {
            throw new InvalidRollException();
        }

        score += i;
        totalRolls++;

        if (score == 10) {
            if (totalRolls == 1) {
                this.isStrike = true;
            } else {
                this.isSpare = true;
            }
        }
    }

    public boolean isOpen() {
        return isStrike || isSpare || totalRolls < 2;
    }

    public int getScore() {
        return score;
    }

    public boolean isStrike() {
        return this.isStrike;
    }

}
