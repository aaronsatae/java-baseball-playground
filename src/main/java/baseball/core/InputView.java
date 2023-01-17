package baseball.core;

public interface InputView {
    Balls getBalls(String message);

    boolean shouldRetry(String message);
}
