package com.example.firstapp;

import com.example.firstapp.Entities.Session;
import com.example.firstapp.Entities.Student;
import com.example.firstapp.repositories.SessionRepository;
import com.example.firstapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class FirstAppApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(FirstAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*********************** Insertion ***********************");
        studentRepository.save(new Student(null, "A1","Amine",new Date(),true,null,null));
        studentRepository.save(new Student(null, "A2","Ilyas",new Date(),true,null,null));
        studentRepository.save(new Student(null, "A3","Saad",new Date(),true,null,null));
        studentRepository.save(new Student(null, "A4","Arij",new Date(),true,null,null));
        studentRepository.save(new Student(null, "A5","Lina",new Date(),true,null,null));
        System.out.println("*********************** Inserted rows ***********************");
        System.out.println("Count : "+studentRepository.count());
        System.out.println("*********************** Display rows ***********************");
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> {
            System.out.println(student.toString());
        });
        System.out.println("*********************** Get Element By ID ***********************");
        Student student = studentRepository.findById(3).orElse(null);
        System.out.println(student.toString());
        System.out.println("*********************** Update an Element ***********************");
        student.setRegistrationNumber("S3");
        studentRepository.save(student);
        System.out.println("*********************** Delete an Element ***********************");
        studentRepository.delete(student);
        System.out.println("Count : "+studentRepository.count());

        studentRepository.deleteById(5);
        System.out.println("Count : "+studentRepository.count());
    }
}