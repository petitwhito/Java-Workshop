package fr.epita.assistants;

import fr.epita.assistants.observer.Lifeguard;
import fr.epita.assistants.observer.Swimmer;
import fr.epita.assistants.observer.SwimmerStatus;

public class Main {

    public static void main(String[] args) {
        final var swimmer = new Swimmer("Swimmer");
        final var lifeguard = new Lifeguard("Lifeguard");

        swimmer.register(lifeguard);

        swimmer.setStatus(SwimmerStatus.DROWNING);
    }
}
