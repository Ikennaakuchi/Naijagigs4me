package com.naijagis4me.v1.service.serviceimpl;

import com.naijagis4me.v1.dtos.ProfileDto;
import com.naijagis4me.v1.exceptions.UserNotFoundException;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.repositories.PersonRepository;
import com.naijagis4me.v1.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl  implements PersonService {
    private final PersonRepository personRepository;


    @Override
    public ProfileDto viewProfile(Long userId) {
        Person person = personRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found"));
        ProfileDto profileDto = ProfileDto.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .otherNames(person.getOtherNames())
                .gender(person.getGender())
                .email(person.getEmail())
                .phoneNumber(person.getPhoneNumber())
                .dob(person.getDob())
                .build();
        return profileDto;
    }
}
