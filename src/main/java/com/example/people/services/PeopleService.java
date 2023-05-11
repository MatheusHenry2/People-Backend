package com.example.people.services;

import com.example.people.models.PeopleModel;
import com.example.people.repositories.PeopleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    final
    PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public PeopleModel save(PeopleModel peopleModel) {
        return peopleRepository.save(peopleModel);
    }

    public List<PeopleModel> findAll(){
        return peopleRepository.findAll();
    }
}
