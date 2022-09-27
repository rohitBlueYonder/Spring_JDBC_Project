package com.spring.boot.jdbc.SpringBootJDBCProject.Entity;
//import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Date;


@Entity
// Rowmapping(create schema/Database)
@NamedQuery(name="get_all_players", query="select p from Player p")
@Table(name="Player")
public class Player {
    @Id
    @GeneratedValue
    private int id;
    // auto generated on new row insertion

    @Column(name="Name")
    private String name;
    @Column(name="Age")
    private int age;
    @Column(name="Nationality")
    private String nationality;
    @Column(name="DOB")
    private Date dob;
    @Column(name="Designation")
    private int designation;

    public Player() {
    }

    public Player(int id, String name, int age, String nationality, Date dob, int designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.dob = dob;
        this.designation = designation;
    }


    //without id constructor
    public Player(String name, int age, String nationality, Date dob, int designation) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.dob = dob;
        this.designation = designation;
    }


    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getDesignation() {
        return designation;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", dob=" + dob +
                ", designation=" + designation +
                '}';
    }
}
