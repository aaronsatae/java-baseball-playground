package baseball.console;

import baseball.core.Balls;
import baseball.core.RandomBallsGenerator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class DefaultRandomBallsGenerator implements RandomBallsGenerator {
    private static final Random random = new Random();

    @Override
    public Balls generateBalls() {
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() != Balls.BALL_COUNT) {
            numbers.add(random.nextInt(9) + 1);
        }
        return new Balls(new ArrayList<>(numbers));
    }
}
