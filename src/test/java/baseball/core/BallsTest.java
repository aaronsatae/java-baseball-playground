package baseball.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {
    @Test
    void invalidConstructorInput() {
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 2, 3, 4))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 2))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equals() {
        Balls balls1 = new Balls(Arrays.asList(1, 2, 3));
        Balls balls2 = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls1).isEqualTo(balls2);

        Balls balls3 = new Balls(Arrays.asList(2, 1, 3));
        assertThat(balls1).isNotEqualTo(balls3);
    }

    @Test
    void ball() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(1, 2);
        BallStatus result = answer.play(ball);

        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(2, 2);
        BallStatus result = answer.play(ball);

        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void nothing() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(4, 2);
        BallStatus result = answer.play(ball);

        assertThat(result).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void playTest() {
        Balls balls1 = new Balls(Arrays.asList(1, 2, 3));
        Balls balls2 = new Balls(Arrays.asList(1, 2, 3));

        PlayResult result = balls1.play(balls2);

        assertThat(result).isEqualTo(new PlayResult(3, 0));
    }
}