package baseball.core;

import java.util.Objects;

public class PlayResult {
    private final int strikeCount;
    private final int ballCount;

    public PlayResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isFinished() {
        return this.strikeCount == Balls.BALL_COUNT;
    }

    public String getResultMessage() {
        if (0 < this.ballCount && 0 < this.strikeCount) {
            return this.ballCount + "볼 " + this.strikeCount + "스트라이크";
        }
        if (0 < this.strikeCount) {
            return this.strikeCount + "스트라이크";
        }
        if (0 < this.ballCount) {
            return this.ballCount + "볼";
        }
        return "낫싱";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayResult that = (PlayResult) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
