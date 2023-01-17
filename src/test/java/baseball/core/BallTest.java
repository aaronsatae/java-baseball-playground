package baseball.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void invalidPosition(int position) {
        Assertions.assertThatThrownBy(() -> new Ball(1, position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void invalidValue(int value) {
        Assertions.assertThatThrownBy(() -> new Ball(value, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void strike() {
        Ball ball1 = new Ball(1, 1);
        Ball ball2 = new Ball(1, 1);

        BallStatus actual = ball1.play(ball2);

        Assertions.assertThat(actual).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball ball1 = new Ball(1, 1);
        Ball ball2 = new Ball(1, 2);

        BallStatus actual = ball1.play(ball2);

        Assertions.assertThat(actual).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball ball1 = new Ball(2, 1);
        Ball ball2 = new Ball(1, 2);

        BallStatus actual = ball1.play(ball2);

        Assertions.assertThat(actual).isEqualTo(BallStatus.NOTHING);
    }
}