package fr.epita.assistants.ministreamsmusic.dataaccess;

import fr.epita.assistants.ministreamsmusic.data.Song;

import java.util.List;

public class StreamsSongs {
    public static List<String> getOlderArtists(List<Song> songs) {
        return songs.stream()
                .filter(c -> c.getArtist().getAge() >= 30)
                .map(c -> c.getArtist().getSurname())
                .distinct()
                .limit(10)
                .toList();
    }

    public static Integer getSumAges(List<Song> songs) {
        return songs.stream()
                .filter(c -> c.getArtist().getAge() >= 20)
                .mapToInt(c -> c.getArtist().getAge())
                .sum();
    }

    public static List<String> getMusics(List<Song> songs) {
        return songs.stream()
                .filter(c -> c.getArtist().getName().toLowerCase().contains("an"))
                .map(c -> c.getName())
                .limit(10)
                .toList();
    }
}
