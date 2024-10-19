package com.spring.crud_person.services;

import com.spring.crud_person.entities.Person;
import com.spring.crud_person.repositories.PersonRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }
    public List<Person> read() {
        return personRepository.findAll();
    }
    public Person update(Person person) {
        Person personCreated = personRepository.findById(person.getId()).orElseThrow(() -> new NoSuchElementException("Person with " + person.getId() + "does not exist"));

        personCreated.setAge(person.getAge());
        personCreated.setName(person.getName());
        personCreated.setCpf(person.getCpf());

        return personRepository.save(personCreated);
    }
    public void delete(Long id) {
        Person personCreated = personRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Person with " + id + "does not exist"));

        personRepository.delete(personCreated);
    }
    public Person readById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Person with " + id + "does not exist"));
    }
}
