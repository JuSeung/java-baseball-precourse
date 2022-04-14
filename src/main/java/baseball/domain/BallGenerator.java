package baseball.domain;


import static baseball.env.RestrictionsNumber.END_NUMBER;
import static baseball.env.RestrictionsNumber.SIZE_LIMIT_NUMBER;
import static baseball.env.RestrictionsNumber.START_NUMBER;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
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
			int randomNumber = Randoms.pickNumberInRange(START_NUMBER.getNumber(), END_NUMBER.getNumber());
			addNumber(randomNumber);
		}
	}

	private boolean isListSizeEqualLimit() {
		return this.ballNumbers.size() == SIZE_LIMIT_NUMBER.getNumber();
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