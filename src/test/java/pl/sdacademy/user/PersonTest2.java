package pl.sdacademy.user;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.sdacademy.exceptions.PersonUpdateFailedException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest2 {
    @ParameterizedTest
    @MethodSource("getAgeArgs")
    void shouldThrowExceptionWhenAgeIsIncorrect(final Integer age){
        //given
        final String email = "someEmail@gmail.com";
        final Person person = new Person();

        assertThrows(PersonUpdateFailedException.class,
                () -> person.setPersonDetails(email, age));
    }
    // met. getAgeArgs zadaje do kodu parametry null oraz 0, które wygenerują błędy
    public static Stream<Arguments> getAgeArgs(){
        return Stream.of(
                Arguments.of(null),
                Arguments.of(0)
        );
    }
}