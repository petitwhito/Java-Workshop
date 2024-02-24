package fr.epita.assistants.ministreamsmusic.data;

public class Song {
    private String name;
    private int duration;
    private Artist artist;

    public Song(String name, int duration, Artist artist) {
        this.name = name;
        this.duration = duration;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }
}
