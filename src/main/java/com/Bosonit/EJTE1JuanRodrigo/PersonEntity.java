package com.Bosonit.EJTE1JuanRodrigo;



import javax.persistence.*;

@Entity
@Table(name = "Sonarqube")

public class PersonEntity {
    @Id
    @GeneratedValue
    Integer id_person;
    @Column(name = "usuario")
    String user;
    @Column(name = "ciudad")
    String city;

    public PersonEntity(Integer id_person, String user  , String city){

        this.id_person = id_person;
        this.user = user;
        this.city = city;
    }


    public PersonEntity(String user , String city){
        this.user = user;
        this.city = city;


    }
    public PersonEntity(){

    }

    public void setUser(String user){this.user = user;}

    public void setCity(String city){this.city = city;}

    public Integer getId_person() {
        return id_person;
    }
    public String getUser(){
        return user;
    }
    public String getCity(){
        return city;
    }
}
