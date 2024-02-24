package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements Assignable{
    private List<String> projects;
    public Manager(String lastName, String firstName) {
        super(lastName, firstName);
        projects = new ArrayList<>();
    }

    @Override
    public void sayMyJob() {
        System.out.println(getFirstName() + " " + getLastName() + " is a manager.");
    }

    @Override
    public void addProject(String project) {
        if (!projects.contains(project))
            projects.add(project);
    }

    @Override
    public boolean hasProject(String project) {
        return projects.contains(project);
    }

    @Override
    public void listProjects() {
        System.out.println(this.toString() + "'s current projects are:");
        for (String ele: projects) {
            System.out.println("- " + ele);
        }
    }

    public boolean is_empty()
    {
        return projects.isEmpty();
    }
}
