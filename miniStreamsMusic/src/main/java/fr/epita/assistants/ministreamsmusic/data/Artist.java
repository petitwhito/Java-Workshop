package fr.epita.assistants.ministreamsmusic.data;

public class Artist {
    private int age;
    private String name;
    private String surname;

    public Artist(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
