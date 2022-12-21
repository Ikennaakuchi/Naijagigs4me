package com.naijagis4me.v1.service.serviceimpl;

import com.naijagis4me.v1.repositories.PersonRepository;
import com.naijagis4me.v1.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl  implements PersonService {
    private final PersonRepository personRepository;


}
