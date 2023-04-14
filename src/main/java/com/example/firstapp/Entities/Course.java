package com.example.firstapp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 25, nullable = false, unique = false)
    private String title;
    private String description;
    private int timing;
    @OneToOne(mappedBy = "course")
    private Professor professor;
    @OneToMany
    private Collection<Session> sessions;

}
