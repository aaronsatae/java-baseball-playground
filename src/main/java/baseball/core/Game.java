package baseball.core;

public class Game {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String ENTER_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + NEW_LINE;
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + NEW_LINE;

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomBallsGenerator randomBallsGenerator;
    private Balls answer;

    public Game(InputView inputView, OutputView outputView, RandomBallsGenerator randomBallsGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomBallsGenerator = randomBallsGenerator;
        this.answer = randomBallsGenerator.generateBalls();
    }

    public void play() {
        while (true) {
            Balls balls = this.inputView.getBalls(ENTER_INPUT_MESSAGE);
            PlayResult playResult = this.answer.play(balls);
            this.outputView.write(playResult.getResultMessage() + NEW_LINE);

            if (!playResult.isFinished()) {
                continue;
            }

            this.outputView.write(WIN_MESSAGE);
            if (!this.inputView.shouldRetry(RETRY_MESSAGE)) {
                return;
            }
            this.answer = this.randomBallsGenerator.generateBalls();
        }
    }
}
