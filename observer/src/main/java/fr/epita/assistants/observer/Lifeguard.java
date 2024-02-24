package fr.epita.assistants.observer;

public class Lifeguard implements Observable.Observer<Swimmer> {
    public String name;

    public Lifeguard(String name) {
        this.name = name;
        System.out.println(name + " begins to keep an eye on the swimmers.");
    }

    @Override
    public void onEvent(Swimmer swimmer) {
        switch (swimmer.getStatus()) {
            case DROWNING -> System.out.println(name + ": I will save you " + swimmer.getName() + "!");
            case TOO_FAR -> System.out.println(name + ": " + swimmer.getName() + "! You are too far, come back!");
        }
    }
}
