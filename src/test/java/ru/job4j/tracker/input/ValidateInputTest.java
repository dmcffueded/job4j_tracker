package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultipleValidInputs() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(output, in);

        int firstSelected = input.askInt("Enter menu:");
        assertThat(firstSelected).isEqualTo(1);

        int secondSelected = input.askInt("Enter menu:");
        assertThat(secondSelected).isEqualTo(2);

        int thirdSelected = input.askInt("Enter menu:");
        assertThat(thirdSelected).isEqualTo(3);
    }

    @Test
    void whenValidNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-1", "2"}
        );
        ValidateInput input = new ValidateInput(output, in);

        int secondSelected = input.askInt("Enter menu:");
        assertThat(secondSelected).isEqualTo(-1);

        int thirdSelected = input.askInt("Enter menu:");
        assertThat(thirdSelected).isEqualTo(2);
    }
}