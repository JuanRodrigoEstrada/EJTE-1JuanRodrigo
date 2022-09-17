package com.Bosonit.EJTE1JuanRodrigo;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {


    Optional<PersonEntity> findByUser(String user);

    Optional<PersonEntity> findById(Integer id_person);

    Optional<PersonEntity>findByCity(String city);


}
