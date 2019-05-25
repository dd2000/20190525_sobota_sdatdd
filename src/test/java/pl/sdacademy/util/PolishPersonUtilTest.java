package pl.sdacademy.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PolishPersonUtilTest {

    private PolishPersonUtil polishPersonUtil = new PolishPersonUtil();

    @DisplayName("Value Source Test Example")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Ela", "Kasia", "Ula"})
    void shouldBePolishFemaleName(final String nameArg) {
        final boolean result = polishPersonUtil.isPolishFemaleName(nameArg);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 22})
    void shouldBeNaturalNumber(final int arg) {
        assertTrue(arg > 0);
    }

    @ParameterizedTest
    @MethodSource("getTestArgs")
    void fromMethodTest(final String name, final int age) {
        final boolean isAdult = polishPersonUtil.isPolishFemaleAdult(name, age);
        assertThat(isAdult).isTrue();
    }

    static Stream<Arguments> getTestArgs() {
        return Stream.of(
                Arguments.of("Marcin", 33),
                Arguments.of("Andrzej", 28),
                Arguments.of("Ula", 44));
    }
}