package com.example.people.services;

import com.example.people.models.PeopleModel;
import com.example.people.repositories.PeopleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<PeopleModel> findAll() {
        return peopleRepository.findAll();
    }

    public Optional<PeopleModel> findByid(UUID id) {
        return peopleRepository.findById(id);
    }
    @Transactional
    public void delete(PeopleModel peopleModel) {
        peopleRepository.delete(peopleModel);
    }
}