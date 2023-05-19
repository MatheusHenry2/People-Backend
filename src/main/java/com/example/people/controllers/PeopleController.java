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
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePeople(@PathVariable(value = "id") UUID id) {
        Optional<PeopleModel> peopleModelOptional = peopleService.findByid(id);

        if (!peopleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("People not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(peopleModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePeople(@PathVariable(value = "id") UUID id) {
        Optional<PeopleModel> peopleModelOptional = peopleService.findByid(id);

        if (!peopleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("People not found for delete");
        }

        peopleService.delete(peopleModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("People deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePeople(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid PeopleDto peopleDto) {

        Optional<PeopleModel> peopleModelOptional = peopleService.findByid(id);

        if (!peopleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("People not found for update");
        }

        var peopleModel = peopleModelOptional.get();
        peopleModel.setPeopleName(peopleDto.getPeopleName());
        peopleModel.setPeopleEmail(peopleModel.getPeopleEmail());
        peopleModel.setPeoplePassword(peopleDto.getPeoplePassword());

        return ResponseEntity.status(HttpStatus.OK).body(peopleService.save(peopleModel));
    }
}