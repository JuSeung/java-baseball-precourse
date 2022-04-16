package baseball.domain;


import static baseball.env.RestrictionsNumber.*;

import java.util.List;

public class Referee {
    private int ballCount = 0;
    private int strikeCount = 0;

    public Referee(List<Integer> ballGeneratorList, List<Integer> inputNumberList) {
        initCount();
        calculationBall(ballGeneratorList, inputNumberList);
        calculationStrike(ballGeneratorList, inputNumberList);
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    private void initCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    private void calculationBall(List<Integer> ballGeneratorList, List<Integer> inputNumberList) {
        for (int i = 0; i < SIZE_LIMIT_NUMBER.getNumber(); i++) {
            int numbers = inputNumberList.get(i);
            countBall(ballGeneratorList.contains(numbers), ballGeneratorList.indexOf(numbers) != i);
        }
    }

    private void countBall(boolean isSameNumber, boolean isDifferntIndex) {
        if (isSameNumber && isDifferntIndex) {
            this.ballCount++;
        }
    }

    private void calculationStrike(List<Integer> ballGeneratorList, List<Integer> inputNumberList) {
        for (int i = 0; i < SIZE_LIMIT_NUMBER.getNumber(); i++) {
            countStrike(ballGeneratorList.get(i).equals(inputNumberList.get(i)));
        }
    }

    private void countStrike(boolean isSameNumberAndSameIndex) {
        if (isSameNumberAndSameIndex) {
            this.strikeCount++;
        }
    }


}
