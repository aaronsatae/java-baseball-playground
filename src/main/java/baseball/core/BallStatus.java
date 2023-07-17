package baseball.core;

public enum BallStatus {
    BALL, NOTHING, STRIKE;

    public boolean isStrike() {
        return this.equals(BallStatus.STRIKE);
    }

    public boolean isBall() {
        return this.equals(BallStatus.BALL);
    }
}
