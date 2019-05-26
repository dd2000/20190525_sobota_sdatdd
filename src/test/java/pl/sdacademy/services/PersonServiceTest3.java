package pl.sdacademy.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.user.Person;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class PersonServiceTest3 {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

// ta część jest jednoznaczna z powyższą admotacją @InjectMocks
//    @BeforeEach
//    void setUp(){
//        //personRepository = new PersonRepository(); // tego nie potrzebujemy
//        personService = new PersonService(personRepository);
//    } // setUp()

    @Test
    void shouldFindPersonByEmailGivenEmailExistInRepository(){
        //given
        final  String lookedEmail = "test@gmail.com";
        when(personRepository.getPersonList()).thenReturn(Collections.singletonList(
                Person.builder().email(lookedEmail).build()
        ));
        //when
        final Person person = personService.getByEmail(lookedEmail);

        assertThat(person.getEmail()).isEqualTo(lookedEmail);
        verify(personRepository).getPersonList();
    }

    @Test
    void shouldGetPersonByEmail(){
        final String lockedEmail = "test@gmail.com";
        when(personRepository.getPersonList())
                .thenReturn(Collections.singletonList(
                        Person.builder().email(lockedEmail).build()
                ));

        final Optional<Person> person = personService.findByEmail(lockedEmail);

        assertThat(person).isPresent().
                hasValueSatisfying(p -> p.getEmail().equals(lockedEmail) );
        verify(personRepository).getPersonList();
    }

    @Test
    void shouldNotFinfPersonByEmailWhenEmailNotExist(){
        final String email = "nonono@gmail.com";
        when(personRepository.getPersonList())
                .thenReturn(Collections.emptyList());

        final Optional<Person> person = personService.findByEmail(email);

        assertThat(person).isPresent().
                hasValueSatisfying(p -> p.getEmail().equals(email) );

        verify(personRepository).getPersonList();
    }


}