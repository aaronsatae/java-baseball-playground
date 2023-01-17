package baseball.console;

import baseball.core.Game;
import baseball.core.InputView;
import baseball.core.OutputView;
import baseball.core.RandomBallsGenerator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        RandomBallsGenerator randomBallsGenerator = new DefaultRandomBallsGenerator();
        Game game = new Game(inputView, outputView, randomBallsGenerator);

        game.play();
    }
}
