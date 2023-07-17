package baseball.console;

import baseball.core.Balls;
import baseball.core.InputView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Balls getBalls(String message) {
        Balls result = null;
        do {
            System.out.print(message);
            String input = scanner.nextLine();
            List<Integer> numbers = input.chars().boxed().map(c -> c - '0').collect(Collectors.toList());

            try {
                result = new Balls(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (result == null);
        return result;
    }

    @Override
    public boolean shouldRetry(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                return true;
            }
            if (input.equals("2")) {
                return false;
            }
        }
    }
}
