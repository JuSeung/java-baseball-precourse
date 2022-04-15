package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("자릿수가 3자리 이다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "231", "356"})
    void validationNumberLength_case1(String inputNumbers) {
        // when
        int size = inputNumbers.length();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("자릿수가 3자리 초과이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "4567", "7890"})
    void validationNumberLength_case2_over_length(String inputNumbers) {
        // when
        int size = inputNumbers.length();

        // then
        assertThat(size).isNotEqualTo(3);
    }

    @DisplayName("숫자인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void validationNumberType_case1_true(String inputNumbers) {
        // given
        String regex = "[0-9]+";

        // when & then
        assertThat(inputNumbers.matches(regex)).isTrue();
    }

    @DisplayName("숫자가 아닌경우")
    @ParameterizedTest
    @ValueSource(strings = {"12a", "a12", "2a1"})
    void validationNumberType_case2_false(String inputNumbers) {
        // when
        String regex = "[0-9]+";

        // then
        assertThat(inputNumbers.matches(regex)).isFalse();
    }

    @DisplayName("1에서 9사이 숫자인경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 4, 5})
    void validationNumberRange_case1_false(int number) {
        // when & then
        assertThat((number < 1 || number > 9)).isFalse();
    }

    @DisplayName("1에서 9사이가 아닌경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 20, 11})
    void validationNumberRange_case2_true(int number) {
        // when & then
        assertThat((number < 1 || number > 9)).isTrue();
    }

    @DisplayName("동일한 숫자가 있는경우")
    @Test
    void validationNumberDuplication_case_true() {
        // given
        List<Integer> list = new ArrayList<>();
        list.add(1);
        // when & then
        assertThat(list.contains(1)).isTrue();
    }

    @DisplayName("동일한 숫자가 없는경우")
    @Test
    void validationNumberDuplication_case_false() {
        // given
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // when & then
        assertThat(list.contains(3)).isFalse();
    }

    @DisplayName("String 숫자 -> Char -> int 형으로 바꾼다.")
    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void generatorNumbersToListTest(String inputNumbers) {
        // given
        List<Integer> list = new ArrayList<>();

        // when
        for (char number : inputNumbers.toCharArray()) {
            int addNumber = Character.getNumericValue(number);
            list.add(addNumber);
        }
        // then
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
    }


    @DisplayName("3자리이상 입력시 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"1253", "5123", "7896"})
    void over_number_exception(String inputNumbers) {
        // given
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumberList(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리만 입력 가능 합니다.");
    }


    @DisplayName("숫자가 아닌 값을 입력시 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"a13", "2a3", "23z"})
    void no_number_exception(String inputNumbers) {
        // given
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumberList(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능 합니다.");

    }


    @DisplayName("한 자리 숫자는 1에서 9까지 이다. 아니면 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"101", "202", "303"})
    void range_number_exception(String inputNumbers) {
        // given
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumberList(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 자릿수는 1에서 9까지 입니다.");

    }

    @DisplayName("한 자리 숫자는 1에서 9까지 이다. 아니면 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"121", "232", "353"})
    void duplication_number_exception(String inputNumbers) {
        // given
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumberList(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자는 허용하지 않습니다.");

    }

    @DisplayName("입력한 숫자가 1 또는 2가 아니면I llegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4"})
    void command_exception(String inputNumbers) {
        // given
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.isRestart(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("명령어는 1(시작)과 2(종료)만 가능합니다.");

    }


}