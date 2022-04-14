package baseball.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {
    

    @DisplayName("3자리이상 입력시 IllegalArgumentException을 던진다.")
    @Test
    void over_number_exception() {
        // given
        String input = "1234";
        System.setIn(getInputStream(input));
        InputView inputView = new InputView();

        // when / then
        assertThatThrownBy(() -> {
            inputView.askInputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }


    private static InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}