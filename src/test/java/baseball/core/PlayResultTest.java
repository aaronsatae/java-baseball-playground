package baseball.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayResultTest {
    @Test
    void isFinishedTest() {
        PlayResult playResult1 = new PlayResult(3, 0);
        assertThat(playResult1.isFinished()).isTrue();

        PlayResult playResult2 = new PlayResult(1, 0);
        assertThat(playResult2.isFinished()).isFalse();
    }

    @Test
    void equalsTest() {
        assertThat(new PlayResult(1, 2)).isEqualTo(new PlayResult(1, 2));
    }

    @Test
    void strikeOnlyString() {
        assertThat(new PlayResult(1, 0).getResultMessage()).isEqualTo("1스트라이크");
    }

    @Test
    void ballOnlyString() {
        assertThat(new PlayResult(0, 2).getResultMessage()).isEqualTo("2볼");
    }

    @Test
    void strikeAndBallString() {
        assertThat(new PlayResult(1, 2).getResultMessage()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void nothingString() {
        assertThat(new PlayResult(0, 0).getResultMessage()).isEqualTo("낫싱");
    }
}