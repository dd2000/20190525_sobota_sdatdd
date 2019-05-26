package pl.sdacademy.calculations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.exceptions.DivisionByZeroException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest2 {
    // wykorzystanie metod i struktury ze slajdu 31: beforeEach, beforeAl ....

    private Calculator calculator;    // utworzenie prywatnej zmiennej calkulator
    @BeforeEach
    void setUp(){
        calculator = new Calculator(); // ten kod będzie wykonany przed każdym testem
            // a więc tę linię można usunąć  z każdego testu (1,2,3,4)
    }


    // test1
    @Test
    void shouldAddTwoNumbers(){
        //given
        //final Calculator calculator = new Calculator();
        final double val1 = 3.2;
        final double val2 = 4.1;

        //when
        final double actualValue = calculator.add(val1,val2);

        //then
        assertEquals(7.3, actualValue);  // oczekiwany rezultat(7.3) porównywany z actualValue
    } //shouldAddTwoNumbers()

    // test2
    @Test
    void shouldMultiplyTwoNumbers(){
        //given
        //final Calculator calculator = new Calculator();
        final double val1 = 2.0;
        final double val2 = 3.1;

        //when
        final double actualValue = calculator.multiply(val1,val2);

        //then
        assertEquals(6.2, actualValue);  // oczekiwany rezultat(6.2) porównywany z actualValue

    } // shouldMultiplyTwoNumbers()

    // test3
    @Test
    void shouldSubstractTwoNumbers(){
        //given
        //final Calculator calculator = new Calculator();
        final double val1 = 2.5;
        final double val2 = 3.8;

        //when
        final double actualValue = calculator.subtract(val1,val2);

        //then

        //assertEquals(-1.3, actualValue);  // oczekiwany rezultat(6.2) porównywany z actualValue
        // w tym teście: test nie przechodzi, bo: wartość Actual to:-1.2999999999999998, a nie -1,3
        // wynika to z wyniku działań na liczbach zmiennoprzecinkowych

        // rozwiązaniem jest dodanie do assertEquals trzeciego parametru - delta = dopuszczalna różnica
        assertEquals(-1.3, actualValue,0.1);  // delta=0.1oczekiwany rezultat(6.2) porównywany z actualValue
        //teraz ten test przechodzi

    } // shouldSubstractTwoNumbers()

    // test4
    @Test
    void shouldAlwaysFail(){ // tylko asercja poniżej, bez danych given i when
        //given

        //when

        //then
        assertEquals(1,2,"Jeden nie jest równe 2");

    } // shouldAlwaysFail()


    @Test
    void shouldThrowExceptionWhenDividingByZero(){
        //given
        final double val1 = 2.0;
        final double val2 = 0.0;
        //when
        try{
            calculator.divide(val1,val2);
            fail("Exception excepted but not thrown.");
        } catch (final DivisionByZeroException exp){
            // przypuszczenia co do wyjątku
            assertThat(exp.getMessage()).isEqualTo("Canot divide by 0!");

        } // try-catch
    }



}  // class CalculatorTest2