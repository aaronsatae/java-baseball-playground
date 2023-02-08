package baseball.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class GameTest {

    class TestInputView implements InputView {
        private Queue<Balls> ballss;

        public TestInputView(Queue<Balls> ballss) {
            this.ballss = ballss;
        }

        @Override
        public Balls getBalls(String message) {
            return ballss.poll();
        }

        @Override
        public boolean shouldRetry(String message) {
            return false;
        }
    }

    class TestOutputView implements OutputView {
        private String buffer = "";

        @Override
        public void write(String message) {
            buffer += message;
        }

        public String getBuffer() {
            return buffer;
        }
    }

    class TestAnswerGenerator implements RandomBallsGenerator {
        private Balls answer;

        public TestAnswerGenerator(Balls answer) {
            this.answer = answer;
        }

        @Override
        public Balls generateBalls() {
            return this.answer;
        }
    }


    @Test
    void name() {
        TestInputView inputView = new TestInputView(new LinkedList<>(
                Arrays.asList(
                        new Balls(Arrays.asList(3, 4, 1)),
                        new Balls(Arrays.asList(1, 2, 3))
                )
        ));
        TestOutputView outputView = new TestOutputView();
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        TestAnswerGenerator randomBallsGenerator = new TestAnswerGenerator(answer);

        Game sut = new Game(inputView, outputView, randomBallsGenerator);
        sut.play();

        String[] outputMessages = outputView.getBuffer().split("\n");
        Assertions.assertThat(outputMessages[0]).isEqualTo("2볼");
        Assertions.assertThat(outputMessages[1]).isEqualTo("3스트라이크");
        Assertions.assertThat(outputMessages[2]).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}