package fr.epita.assistants.mykitten;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyKitten {
    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */


    public MyKitten(String srcPath) {
        try {
            streamContent = Files.lines(Paths.get(srcPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {
        AtomicInteger index = new AtomicInteger();
        index.incrementAndGet();
        this.streamContent = this.streamContent
                .map(line -> line.replaceAll(wordToReplace, "miaou")).map(
                        i -> index.getAndIncrement() + " " + i
                );

    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
         try {
            Files.write(Paths.get(destPath), (Iterable<String>) streamContent::iterator);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to destination file", e);
        }

    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) {
        MyKitten myKitten = new MyKitten(srcPath);
        myKitten.replaceByMiaou(wordToReplace);
        myKitten.toFile(destPath);
    }

    public Stream<String> streamContent;
}
