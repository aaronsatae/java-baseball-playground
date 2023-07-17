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
    void playTest() {
        Balls balls1 = new Balls(Arrays.asList(1, 2, 3));
        Balls balls2 = new Balls(Arrays.asList(1, 2, 3));

        PlayResult result = balls1.play(balls2);

        assertThat(result).isEqualTo(new PlayResult(3, 0));
    }

    @Test
    void playTest2() {
        Balls balls1 = new Balls(Arrays.asList(1, 2, 3));
        Balls balls2 = new Balls(Arrays.asList(2, 1, 3));

        PlayResult result = balls1.play(balls2);

        assertThat(result).isEqualTo(new PlayResult(1, 2));
    }

    @Test
    void playTest3() {
        Balls balls1 = new Balls(Arrays.asList(1, 2, 3));
        Balls balls2 = new Balls(Arrays.asList(5, 3, 1));

        PlayResult result = balls1.play(balls2);

        assertThat(result).isEqualTo(new PlayResult(0, 2));
    }

    @Test
    void playTest4() {
        Balls balls1 = new Balls(Arrays.asList(1, 2, 3));
        Balls balls2 = new Balls(Arrays.asList(6, 4, 5));

        PlayResult result = balls1.play(balls2);

        assertThat(result).isEqualTo(new PlayResult(0, 0));
    }
}