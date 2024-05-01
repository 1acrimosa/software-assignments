import java.util.ArrayList;
import java.util.List;

class Song {
      private String title;
      private String artist;

      public Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
      }

      public String getTitle() {
            return title;
      }

      public String getArtist() {
            return artist;
      }
}

interface Iterator {
      boolean hasNext();
      Song next();
}

interface Playlist {
      Iterator createIterator();
      void addSong(Song song);
}

class PlaylistIterator implements Iterator {
      private List<Song> songs;
      private int position = 0;

      public PlaylistIterator(List<Song> songs) {
            this.songs = songs;
      }

      public boolean hasNext() {
            return position < songs.size();
      }

      public Song next() {
            Song song = songs.get(position);
            position++;
            return song;
      }
}

class PlaylistImpl implements Playlist {
      private List<Song> songs;

      public PlaylistImpl() {
            this.songs = new ArrayList<>();
      }

      public Iterator createIterator() {
            return new PlaylistIterator(songs);
      }

      public void addSong(Song song) {
            songs.add(song);
      }
}

public class Ex2 {
      public static void main(String[] args) {
            Playlist playlist = new PlaylistImpl();

            playlist.addSong(new Song("Come as you are", "Nirvana"));
            playlist.addSong(new Song("Sugar", "System of a down"));
            playlist.addSong(new Song("bad guy", "Billie Eilish"));

            Iterator iterator = playlist.createIterator();
            while (iterator.hasNext()) {
                  Song song = iterator.next();
                  System.out.println("Playing: " + song.getTitle() + " by " + song.getArtist());
            }
      }
}
