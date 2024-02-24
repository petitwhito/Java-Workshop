package fr.epita.assistants;

import fr.epita.assistants.grades.*;
import fr.epita.assistants.grades.model.*;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        GradeHandler handler = new GradeHandler();

        Student.StudentBuilder studentBuilder = Student.builder()
                                                       .age(21);

        String[] frais = {"Roki", "Pulpa", "Split", "Guacamo", "Javotte", "Trognon", "Boomerang", "Fripouille"};

        Stream.of(frais)
              .forEach(name -> handler.addStudent(studentBuilder.name(name)
                                                                .grades(new ArrayList<>())
                                                                .build()));

        try {
            handler.getStudent("Bob");
        } catch (EntryNotFoundException e) {
            System.err.println(e.getMessage());
        }

        Activity mathMidterm = new Activity("Midterm",
                                            Subject.Maths,
                                            1);
        Activity mathFinal = new Activity("Final",
                                          Subject.Maths,
                                          2);
        handler.addActivity(mathMidterm);
        handler.addActivity(mathFinal);

        Random rand = new Random();
        Stream.of(mathMidterm,
                  mathFinal)
              .forEach(exam -> Stream.of(frais)
                                     .forEach(name -> handler.addGradeToStudent(new Grade(exam,
                                                                                          rand.nextInt(10)),
                                                                                name)));

        Stream.of(frais)
              .map(name -> Map.entry(name,
                                     handler.getStudentAverageInSubject(name,
                                                                        Subject.Maths)))
              .forEach(System.out::println);
    }
}
