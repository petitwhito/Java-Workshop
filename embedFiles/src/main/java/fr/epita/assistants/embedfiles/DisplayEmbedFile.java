package fr.epita.assistants.embedfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.stream.Collectors;

public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream == null)
            return Optional.empty();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String data = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        data = data + '\n';
        return Optional.of(data);
    }
}
