package pl.sdacademy.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class IntegerUtilsTest {

    private IntegerUtils integerUtils;

    @BeforeEach
    void setUp(){
        integerUtils = new IntegerUtils();
    }

    @Test
    void shouldFilterDigitsWhenProvidingNonEmptyFilters(){

        //given
        final int toFilter = 12345;
        final List<Integer> filters = Arrays.asList(2,4);

        //when
        final List<Integer> filteredDigits = integerUtils.filter(toFilter, filters);

        //then
//        assertTrue(!filteredDigits.isEmpty());  // tu na końcu średnik - (instrukcja)
//        assertEquals(3,filteredDigits.size());
//        assertTrue(filteredDigits.contains(1));
//        assertTrue(filteredDigits.contains(3));
//        assertTrue(filteredDigits.contains(5));
// można zastąpić poniższym:


            // lambdy bez argumentów dla assertAll
        assertAll(
            () -> assertTrue(!filteredDigits.isEmpty()),    // tu na końcu przecinek, nie średnik
            () -> assertEquals(3,filteredDigits.size()),
            () -> assertTrue(filteredDigits.contains(1)),
            () -> assertTrue(filteredDigits.contains(3)),
            () -> assertTrue(filteredDigits.contains(5))
        );

    }

    @Test
    void shouldFilterDigitsGreatherThat(){
        final int toFilter = 123456;
        final int bound = 3;

        final List<Integer> filteredValues = integerUtils.filterDigitsGreaterThan(toFilter,bound);

           // 123456  ->  [ 4, 5, 6]
        assertThat(filteredValues).isNotEmpty().hasSize(3).containsExactlyInAnyOrder(4,5,6);
    }

    @Test
    void shouldGetLastEvenDigit(){
       final int value = 12345;

       final Optional<Integer> actualLastEvenDigit = integerUtils.getLastEvenDigit(value);

       assertThat(actualLastEvenDigit).isPresent().hasValue(4);

    }

} // class IntegerUtilsTest