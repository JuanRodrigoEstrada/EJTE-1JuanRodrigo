package com.Bosonit.EJTE1JuanRodrigo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PersonEntityTest {
    @Test
    public void createPerson(){
        PersonEntity personEntity = new PersonEntity(1,"Juan Rodrigo","Majadahonda");
        Assertions.assertThat(personEntity.getId_person()).isEqualTo(1);
        Assertions.assertThat(personEntity.getUser()).isEqualTo("Juan Rodrigo");
        Assertions.assertThat(personEntity.getCity()).isEqualTo("Majadahonda");


    }
}
