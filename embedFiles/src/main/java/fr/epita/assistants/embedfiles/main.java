package fr.epita.assistants.embedfiles;


import fr.epita.assistants.embedfiles.DisplayEmbedFile;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class main {
    public static void main(String[] args) {
        final var embedFile = new DisplayEmbedFile("sample.txt");
        final var result = embedFile.display().orElseThrow();
        assertTrue(result.contains("This is a sample"));
    }
}
