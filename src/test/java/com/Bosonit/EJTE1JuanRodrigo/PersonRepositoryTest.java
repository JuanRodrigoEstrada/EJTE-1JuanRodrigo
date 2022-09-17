package com.Bosonit.EJTE1JuanRodrigo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePersonTest(){
        PersonEntity personEntity = new PersonEntity("Juan Rodrigo", "Majadahonda");
        personRepository.save(personEntity);
        Assertions.assertThat(personEntity.getId_person()).isPositive();

    }
    @Test
    @Order(2)
    public void getPersonTest(){

        PersonEntity personEntity = personRepository.findById(1).get();
        Assertions.assertThat(personEntity.getId_person()).isEqualTo(1);

    }
    @Test
    @Order(3)
    public void getpersonByCity() {
        Optional<PersonEntity> OptionalPerson = personRepository.findByCity("Majadahonda");
        Assertions.assertThat(OptionalPerson.get().getCity()).isEqualTo("Majadahonda");
    }
    @Test
    @Order(4)
    public void getListOfPeople(){
        List<PersonEntity>People = personRepository.findAll();
        Assertions.assertThat(People.size()).isPositive();
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void updatePersonTest(){
        PersonEntity personEntity = personRepository.findById(1).get();
        personEntity.setCity("Londres");
        PersonEntity updatePerson = personRepository.save(personEntity);
        Assertions.assertThat(updatePerson.getCity()).isEqualTo("Londres");


    }
    @Test
    @Order(6)
    @Rollback(value = false)
    public void deletePersonTest(){
        PersonEntity personEntity = personRepository.findById(1).get();
        personRepository.delete(personEntity);
        PersonEntity nullPerson = null;
        Optional<PersonEntity>optionalPerson = personRepository.findByUser("Juan Rodrigo");

        if(optionalPerson.isPresent()){
            nullPerson = optionalPerson.get();

        }
        Assertions.assertThat(nullPerson).isNull();
    }




}
