package baseball.core;

import java.util.*;

public class Balls {
    public static final int BALL_COUNT = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        if (numbers == null || numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("Balls의 크기는 " + BALL_COUNT + "이어야 합니다.");
        }
        this.balls = convertIntegerToBall(numbers);
    }

    private static List<Ball> convertIntegerToBall(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        int position = 1;
        for (int number : numbers) {
            balls.add(new Ball(number, position++));
        }
        return balls;
    }

    public PlayResult play(Balls other) {
        int strikeCount = 0;
        int ballCount = 0;
        for (Ball ball : other.balls) {
            BallStatus ballStatus = this.play(ball);
            if (ballStatus.isStrike()) {
                strikeCount += 1;
            }
            if (ballStatus.isBall()) {
                ballCount += 1;
            }
        }

        return new PlayResult(strikeCount, ballCount);
    }

    public BallStatus play(Ball other) {
        Set<BallStatus> result = new HashSet<>();
        for (Ball ball : this.balls) {
            result.add(ball.play(other));
        }
        if (result.contains(BallStatus.STRIKE)) {
            return BallStatus.STRIKE;
        }
        if (result.contains(BallStatus.BALL)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
