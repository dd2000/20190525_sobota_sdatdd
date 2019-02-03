package pl.sdacademy.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private static final String FIRST_NAME = "Michal";
    private static final String LAST_NAME = "Kowalski";

    @Test
    void shouldCreatePersonCorrectly() {
        final Person person = Person.create(FIRST_NAME, LAST_NAME);

        assertAll(
                () -> assertEquals(FIRST_NAME, person.getFirstName()),
                () -> assertEquals(LAST_NAME, person.getLastName())
        );
    }
}