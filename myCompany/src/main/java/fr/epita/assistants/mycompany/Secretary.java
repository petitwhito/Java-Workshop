package fr.epita.assistants.mycompany;

public class Secretary extends Employee {

    public Secretary(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void sayMyJob() {
        System.out.println(getFirstName() + " " + getLastName() + " is a secretary.");
    }
}
