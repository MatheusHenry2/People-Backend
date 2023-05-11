package com.example.people.controllers;

import com.example.people.dtos.PeopleDto;
import com.example.people.models.PeopleModel;
import com.example.people.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/people")
public class PeopleController {

    final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    public ResponseEntity<Object> savePeople(@RequestBody @Valid PeopleDto peopleDto) {
        var peopleModel = new PeopleModel();
        BeanUtils.copyProperties(peopleDto, peopleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(peopleService.save(peopleModel));
    }

    @GetMapping
    public ResponseEntity<List<PeopleModel>> getAllPeopleModel() {
        return ResponseEntity.status(HttpStatus.OK).body(peopleService.findAll());
    }
}
