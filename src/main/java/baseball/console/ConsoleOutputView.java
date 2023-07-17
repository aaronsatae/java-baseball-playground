package baseball.console;

import baseball.core.OutputView;

public class ConsoleOutputView implements OutputView {
    @Override
    public void write(String message) {
        System.out.print(message);
    }
}
