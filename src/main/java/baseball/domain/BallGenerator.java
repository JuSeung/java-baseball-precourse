package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
	private static final int SIZE_LIMIT_NUMBER = 3;
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;

	private final List<Integer> ballNumbers;

	public BallGenerator() {
		this.ballNumbers = new ArrayList<>();
		createNonDuplicateNumbers();
	}

	public List<Integer> getBallNumbers() {
		return this.ballNumbers;
	}

	private void createNonDuplicateNumbers() {
		while (!isListSizeEqualLimit()) {
			int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
			addNumber(randomNumber);
		}
	}

	private boolean isListSizeEqualLimit() {
		return this.ballNumbers.size() == SIZE_LIMIT_NUMBER;
	}

	private void addNumber(int number) {
		if (!isDuplicationNumber(number)) {
			this.ballNumbers.add(number);
		}
	}

	private boolean isDuplicationNumber(int number) {
		return this.ballNumbers.contains(number);
	}

}
