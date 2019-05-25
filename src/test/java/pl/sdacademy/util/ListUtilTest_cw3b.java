package pl.sdacademy.util;

import org.junit.jupiter.api.Test;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilTest_cw3b {

    @Test
    void shouldDoubleInputValuesWhenProvideNonEmptyList(){
        //given
        final List<Integer> args = Arrays.asList(1,5,3,10);
        final List<Integer> actualValue = ListUtil.doubleInputValue(args);
        //when
        // ----

        //then
        assertIterableEquals(Arrays.asList(2,10,6,10), actualValue);
        assertSame(args,actualValue);

    } //shouldDoubleInputValuesWhenProvideNonEmptyList()

    @Test
    void shouldReturnEmptyListWhenProvidingEmptyList(){
        //given
        final List<Integer> actualValue = ListUtil.doubleInputValue(Collections.EMPTY_LIST);
        //when
        // ----

        //then
        assertIterableEquals(Arrays.asList(2,10,6,10), actualValue);
        assertSame("",actualValue);

    } //shouldReturnEmptyListWhenProvidingEmptyList(){


}