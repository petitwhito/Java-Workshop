package fr.epita.assistants.exceptions;

public class Student {
    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) throws InvalidAgeException, InvalidNameException, InvalidMajorException {
        this.name = name;
        this.age = age;
        this.major = major.toUpperCase();

        char[] chars = name.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars)
            if(Character.isDigit(c))
                throw new InvalidNameException(name);

        if (age <= 0 || age >= 130)
            throw new InvalidAgeException(age);

        if (!this.major.matches("IMAGE|GISTRE|SRS|SCIA|MTI|TCOM|SIGL|GITM|ICE|SANTE|SSIE|IF|STARTUP|Q"))
            throw new InvalidMajorException(major);

    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Age: " + age + ", Major: " + major;
    }
}
