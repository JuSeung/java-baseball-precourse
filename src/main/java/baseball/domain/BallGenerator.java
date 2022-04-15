package baseball.domain;


import static baseball.env.RestrictionsNumber.END_NUMBER;
import static baseball.env.RestrictionsNumber.SIZE_LIMIT_NUMBER;
import static baseball.env.RestrictionsNumber.START_NUMBER;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {

    public List<Integer> createNonDuplicateNumbers() {
        List<Integer> radomNumberList = new ArrayList<>();
        while (!isListSizeEqualLimit(radomNumberList.size())) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER.getNumber(), END_NUMBER.getNumber());
            addNumber(radomNumberList, randomNumber);
        }
        return radomNumberList;
    }

    private boolean isListSizeEqualLimit(int size) {
        return size == SIZE_LIMIT_NUMBER.getNumber();
    }

    private void addNumber(List<Integer>radomNumberList, int number) {
        if (!isDuplicationNumber(radomNumberList, number)) {
            radomNumberList.add(number);
        }
    }

    private boolean isDuplicationNumber(List<Integer>radomNumberList, int number) {
        return radomNumberList.contains(number);
    }

}
