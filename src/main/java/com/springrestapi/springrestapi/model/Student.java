package com.springrestapi.springrestapi.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")

public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    @Column
    private String name;

    @Column
    private String lname;

    @Column
    private float percentage;

   @Column
   private String branch;

}
