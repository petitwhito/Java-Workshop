package fr.epita.assistants.mycompany;

import java.util.Objects;

public class Engineer extends Employee implements Assignable {
    private String current_project;
    public Engineer(String lastName, String firstName) {
        super(lastName, firstName);
        current_project = null;
    }

    @Override
    public void sayMyJob() {
        System.out.println(getFirstName() + " " + getLastName() + " is an engineer.");
    }

    @Override
    public void addProject(String project) {
        this.current_project = project;
    }

    @Override
    public boolean hasProject(String project) {
        return Objects.equals(this.current_project, project);
    }

    @Override
    public void listProjects() {
        System.out.println(this.toString() + "'s current project is " + current_project + ".");
    }
}
