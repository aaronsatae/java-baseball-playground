package baseball.core;

import java.util.Objects;

public class Ball {
    private static final int VALUE_MIN = 1;
    private static final int VALUE_MAX = 9;
    private static final int POSITION_MIN = 1;
    private static final int POSITION_MAX = 3;
    private final int value;
    private final int position;

    public Ball(int value, int position) {
        if (value < VALUE_MIN || VALUE_MAX < value) {
            throw new IllegalArgumentException(String.format("value should be between %d to %d", VALUE_MIN, VALUE_MAX));
        }
        if (position < POSITION_MIN || POSITION_MAX < position) {
            throw new IllegalArgumentException(String.format("position should be between %d to %d", POSITION_MIN, POSITION_MAX));
        }
        this.value = value;
        this.position = position;
    }

    public BallStatus play(Ball other) {
        if (this.equals(other)) {
            return BallStatus.STRIKE;
        }
        if (this.value == other.value) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return value == ball.value && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, position);
    }
}
