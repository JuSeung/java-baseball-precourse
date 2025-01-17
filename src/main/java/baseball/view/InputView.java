package baseball.view;


import static baseball.env.RestrictionsNumber.END_NUMBER;
import static baseball.env.RestrictionsNumber.SIZE_LIMIT_NUMBER;
import static baseball.env.RestrictionsNumber.START_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String WRONG_NUMBER_SIZE = "3자리만 입력 가능 합니다.";
    private static final String WRONG_NUMBER_TYPE = "숫자만 입력 가능 합니다.";
    private static final String WRONG_NUMBER_RANGE = "각 자릿수는 1에서 9까지 입니다.";
    private static final String WRONG_NUMBER_DUPLICATION = "중복된 숫자는 허용하지 않습니다.";
    private static final String WRONG_COMMAND = "명령어는 1(시작)과 2(종료)만 가능합니다.";
    private static final String RESTART = "1";
    private static final String END = "2";

    public String askInputNumbers() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    public List<Integer> getInputNumberList(String inputNumbers) {
        validationNumberLength(inputNumbers);
        validationNumberType(inputNumbers);
        return generatorNumbersToList(inputNumbers);
    }

    private List<Integer> generatorNumbersToList(String inputNumbers) {
        List<Integer> numberList = new ArrayList<>();
        for (char number : inputNumbers.toCharArray()) {
            int addNumber = Character.getNumericValue(number);
            validationNumberRange(addNumber);
            validationNumberDuplication(numberList, addNumber);
            numberList.add(addNumber);
        }
        return numberList;
    }

    private void validationNumberLength(String inputNumbers) {
        if (inputNumbers.length() != SIZE_LIMIT_NUMBER.getNumber()) {
            throw new IllegalArgumentException(WRONG_NUMBER_SIZE);
        }
    }

    private void validationNumberType(String inputNumbers) {
        String regex = "[0-9]+";
        if (!inputNumbers.matches(regex)) {
            throw new IllegalArgumentException(WRONG_NUMBER_TYPE);
        }
    }

    private void validationNumberRange(int number) {
        if (number < START_NUMBER.getNumber() || number > END_NUMBER.getNumber()) {
            throw new IllegalArgumentException(WRONG_NUMBER_RANGE);
        }
    }

    private void validationNumberDuplication(List<Integer> numberList, int number) {
        if (numberList.contains(number)) {
            throw new IllegalArgumentException(WRONG_NUMBER_DUPLICATION);
        }
    }

    public String askRestartAndEnd() {
        System.out.println(RESTART_END_MESSAGE);
        return Console.readLine();
    }

    public boolean isRestart(String command) {
        validationCommand(command);
        return RESTART.equals(command);
    }

    private void validationCommand(String command) {
        if (!RESTART.equals(command) && !END.equals(command)) {
            throw new IllegalArgumentException(WRONG_COMMAND);
        }
    }


}
