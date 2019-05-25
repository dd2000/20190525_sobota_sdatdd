package pl.sdacademy.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        assertTrue(!filteredDigits.isEmpty());
        assertEquals(3,filteredDigits.size());
        assertTrue(filteredDigits.contains(1));
        assertTrue(filteredDigits.contains(3));
        assertTrue(filteredDigits.contains(5));
    }

}