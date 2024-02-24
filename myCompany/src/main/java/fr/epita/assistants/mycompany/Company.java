package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
    private String name;
    private List<Employee> employees;
    private Map<Employee, Manager> employeeManagement;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.employeeManagement = new HashMap<>();
    }

    public int size()
    {
        return employees.size();
    }

    public void hire(Employee p)
    {
        employees.add(p);
        employeeManagement.put(p, null);
    }

    public void fire(Employee p)
    {
        employees.remove(p);
        employeeManagement.remove(p);
    }

    public void printEmployees()
    {
        System.out.println("The company " + name + " employs:");
        for (Employee e: employees)
        {
            System.out.println("- " + e.toString());
        }
    }

    public boolean addEmployeeManagement(Employee e, Manager m)
    {
        boolean not_e = employees.contains(e);
        boolean not_m = employees.contains(m);
        if (!not_e)
            System.out.println(e.toString() + " is not employed by " + name + ".");
        if (!not_m)
            System.out.println(m.toString() + " is not employed by " + name + ".");
        if (!not_e || !not_m)
            return false;

        Manager me = employeeManagement.get(e);
        employeeManagement.replace(e, m);
        if (me != null)
            System.out.println(e.toString() + " has a new manager.");
        else System.out.println(e.toString() + " now has a manager.");
        return true;
    }

    public void printManager(Employee e)
    {
        Manager me = employeeManagement.get(e);
        if (me != null)
            System.out.println(me.toString() + " manages " + e.toString() + ".");
        else System.out.println(e.toString() + " is managed by nobody.");
    }

    public void printEmployeesProject()
    {
        for (Employee e: employees) {
            if (e instanceof Engineer) {
                Engineer eng = (Engineer) e;
                if (!eng.hasProject(null))
                    eng.listProjects();
            }

            if (e instanceof Manager) {
                Manager man = (Manager) e;
                if (!man.is_empty())
                    man.listProjects();
            }
        }
    }

}
