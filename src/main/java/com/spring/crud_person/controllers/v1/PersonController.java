package com.spring.crud_person.controllers.v1;


import com.spring.crud_person.entities.Person;
import com.spring.crud_person.services.PersonService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/person")
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.ok(personService.create(person));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> read() {
        return ResponseEntity.ok(personService.read());
    }
    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> readById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.readById(id));
    }
}
