package pl.sdacademy.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PolishPersonUtilTest2 {

    private PolishPersonUtil polishPersonUtil;

    @BeforeEach
    void setUp(){
        polishPersonUtil = new PolishPersonUtil();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bojanowski", "Nadratowski", "Bocianowski"})
    void shouldBeTypicalPolishSurname(final String surname){
        // w tego typu teście nie ma sekcji given - dane przychodzą jako ValueSource
        final boolean actualValue = polishPersonUtil.isTypicalPolishSurname(surname);

        assertThat(actualValue).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12", "ski", "wski", "Bojanowska"})
    void shouldNotBeTypicalPolishSurname(final String surname){
        final boolean actualValue = polishPersonUtil.isTypicalPolishSurname(surname);

        assertThat(actualValue).isFalse();
    }


} // class PolishPersonUtilTest2