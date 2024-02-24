package fr.epita.assistants.fgen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FGen {

    private Path currentPath;
    public FGen(final String inputPath)
    {
        this.currentPath = Paths.get("").toAbsolutePath();
        try
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(inputPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null)
                launch_parse(line);
        }
        catch (IOException e) {
            throw new RuntimeException("Error reading input file");
        }
    }

    private void create(String path) {
        Path newPath = currentPath.resolve(path);
        if (path.endsWith("/")) {
            File targetFile = new File(newPath.toString());
            File parent = targetFile.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs())
                return;
            try { Files.createDirectories(newPath); } catch (IOException e) {}
        }
        else {
            File targetFile = new File(newPath.toString());
            File parent = targetFile.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs())
                return;
            try {Files.createFile(newPath);} catch (IOException e) {}
        }
    }

    private void change(String path) {
        Path newPath = currentPath.resolve(path);
        if (!Files.exists(newPath) || !Files.isDirectory(newPath)) {
            throw new RuntimeException("Error reading input file");
        }
        currentPath = newPath;
    }

    void deleteDirectory (File file){
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDirectory(f);
            }
        }
        file.delete();
    }

    private void delete(String path) {
        Path newPath = currentPath.resolve(path);
        deleteDirectory(newPath.toFile());
    }

    private void launch_parse(String line) {
        String[] temp = line.split(" ", 2);
        switch (temp[0]) {
            case "+" -> create(temp[1]);
            case ">" -> change(temp[1]);
            case "-" -> delete(temp[1]);
            default -> throw new RuntimeException("error");
        }
    }
}
