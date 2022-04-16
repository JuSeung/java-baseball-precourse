package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StateTest {

    @DisplayName("볼,스트라이크가 없는경우")
    @ParameterizedTest
    @CsvSource(value = {"0:0"}, delimiter = ':')
    void getMessage_case_nothing(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertThat(state.getMessage()).isEqualTo("낫싱");
    }

    @DisplayName("3볼")
    @ParameterizedTest
    @CsvSource(value = {"0:0"}, delimiter = ':')
    void getMessage_case_three_ball(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertThat(state.getMessage()).isEqualTo("3볼");
    }

    @DisplayName("2볼")
    @ParameterizedTest
    @CsvSource(value = {"2:0"}, delimiter = ':')
    void getMessage_case_two_ball(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertThat(state.getMessage()).isEqualTo("2볼");
    }

    @DisplayName("1볼")
    @ParameterizedTest
    @CsvSource(value = {"1:0"}, delimiter = ':')
    void getMessage_case_one_ball(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertThat(state.getMessage()).isEqualTo("1볼");
    }

    @DisplayName("3스크라이크")
    @ParameterizedTest
    @CsvSource(value = {"0:3"}, delimiter = ':')
    void getMessage_case_strike(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertThat(state.getMessage()).isEqualTo("3스트라이크");
    }

    @DisplayName("2스크라이크")
    @ParameterizedTest
    @CsvSource(value = {"0:2"}, delimiter = ':')
    void getMessage_case_two(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertThat(state.getMessage()).isEqualTo("2스트라이크");
    }

    @DisplayName("1스크라이크")
    @ParameterizedTest
    @CsvSource(value = {"0:1"}, delimiter = ':')
    void getMessage_case_one(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertThat(state.getMessage()).isEqualTo("1스트라이크");
    }

    @DisplayName("3스트라이크 성공")
    @ParameterizedTest
    @CsvSource(value = {"0:3"}, delimiter = ':')
    void getMessage_case_success(int ballCount, int strikeCount) {
        State state = new State(ballCount, strikeCount);
        assertTrue(state.isSuccess());
    }
}