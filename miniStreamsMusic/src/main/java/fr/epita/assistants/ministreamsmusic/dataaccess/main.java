package fr.epita.assistants.ministreamsmusic.data.dataaccess;

import fr.epita.assistants.ministreamsmusic.data.Artist;
import fr.epita.assistants.ministreamsmusic.data.Song;

import java.util.ArrayList;
import java.util.List;

import static fr.epita.assistants.ministreamsmusic.data.dataaccess.StreamsSongs.*;

public class main {
    public static void main(String[] args) {
        Artist a1 = new Artist(30, "Name 1", "Surname 1");
        Artist a2 = new Artist(40, "Nane 2", "Surname 2");
        Artist a3 = new Artist(27, "Name 3", "Surname 3");
        Artist a4 = new Artist(19, "Name 4", "Surname 4");
        Artist a5 = new Artist(18, "Name 5", "Surname 5");
        Artist a6 = new Artist(15, "Name 6", "Surname 6");
        Artist a7 = new Artist(38, "Name 7", "Surname 7");
        Artist a8 = new Artist(40, "Name 8", "Surname 8");
        Artist a9 = new Artist(47, "Nane 9", "Surname 9");
        Artist a10 = new Artist(32, "Name 10", "Surname 10");
        Artist a11 = new Artist(80, "Name 11", "Surname 11");
        Artist a12 = new Artist(60, "Name 12", "Surname 12");
        Artist a13 = new Artist(31, "Nane 13", "Surname 13");
        Artist a14 = new Artist(18, "Nane 14", "Surname 14");
        Artist a15 = new Artist(20, "Name 15", "Surname 15");
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Song 1", 300, a1));
        songs.add(new Song("Song 2", 300, a2));
        songs.add(new Song("Song 3", 300, a3));
        songs.add(new Song("Song 4", 300, a4));
        songs.add(new Song("Song 5", 300, a5));
        songs.add(new Song("Song 6", 300, a6));
        songs.add(new Song("Song 7", 300, a7));
        songs.add(new Song("Song 8", 300, a8));
        songs.add(new Song("Song 9", 300, a9));
        songs.add(new Song("Song 10", 300, a10));
        songs.add(new Song("Song 11", 300, a11));
        songs.add(new Song("Song 12", 300, a12));
        songs.add(new Song("Song 13", 300, a13));
        songs.add(new Song("Song 14", 300, a14));
        songs.add(new Song("Song 15", 300, a15));
        List<String> olderArtists = getOlderArtists(songs);
        Integer ageSums = getSumAges(songs);
        List<String> musics = getMusics(songs);

        System.out.println(olderArtists);
        System.out.println(ageSums);
        System.out.println(musics);
    }
}
