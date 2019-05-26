package pl.sdacademy.calculations;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciSeriesTest {

    //final FibonacciSeries fibonacciSeries = new FibonacciSeries();

    @Test
    void shouldThrowExceptionCalculatingWithNonPositiveIndex (){
        final FibonacciSeries fibonacciSeries = new FibonacciSeries();
        //given
        final int index = 0;

        final Throwable exception = assertThrows( IllegalArgumentException.class,
            () -> fibonacciSeries.compute(index));
    assertThat(exception.getMessage()).contains("had be positive");

    }
}