package fr.epita.assistants.scheduler;

import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {
        var bestShell = MyTask.of(() -> 42)
                .andThenWait(1L, TimeUnit.SECONDS)
                .andThenDo(value -> value + "sh")
                .execute();
        System.out.println(bestShell); // 42sh
    }
}
