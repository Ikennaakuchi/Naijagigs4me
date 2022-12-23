package com.naijagis4me.v1.service.serviceimpl;

import com.naijagis4me.v1.dtos.ProfileDto;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        person = Person.builder()
                .firstName("Iyke")
                .lastName("Josh")
                .otherNames("Manny")
                .gender("Male")
                .email("iykejosh@email.com")
                .phoneNumber("09038393221")
                .build();

    }

    @Test
    void viewProfile() {
            when(personRepository.findById(1L)).thenReturn(Optional.of(person));

            ProfileDto dto = personService.viewProfile(1L);

            verify(personRepository).findById(1L);

            assertEquals("Iyke", dto.getFirstName());
            assertEquals("Josh", dto.getLastName());
            assertEquals("Manny", dto.getOtherNames());
            assertEquals("Male", dto.getGender());
            assertEquals("iykejosh@email.com", dto.getEmail());
            assertEquals("09038393221", dto.getPhoneNumber());
        }
}