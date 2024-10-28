import java.util.*;

class Song {
    String title;
    String artist;
    Song next;
    Song prev;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
        this.prev = null;
    }
}

class Playlist {
    private Song head;
    private Song tail;

    public Playlist() {
        this.head = null;
        this.tail = null;
    }

    // ADD SONG TO THE END OF THE PLAYLIST

    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);
        if (head == null) {
            head = newSong;
            tail = newSong;
        } else {
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
        System.out.println("Added Song : " + title + " By " + artist);
    }

    // REMOVE SONG BY TITLE

    public void removeSong(String title) {
        Song current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Song not found: " + title);
            return;
        }

        if (current == head) {
            head = current.next;
            if (head != null)
                head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null)
                tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Removed song: " + title);
    }

    // DISPLAY ALL SONGS IN PALYLIST

    public void displaylist() {
        Song current = head;
        if (current == null) {
            System.out.println("The palyslist is empty : ");
            return;
        }
        System.out.println("Playlist :");
        while (current != null) {
            System.out.println("-" + current.title + " By " + current.artist);
            current = current.next;
        }
    }

    // PLAY SONG BY TITLE

    public void playSong(String title) {
        Song current = head;
        while(current != null) {
            if(current.title.equalsIgnoreCase(title)) {
                System.out.println("Now playing : " + current.title + " By " + current.artist);
                return;
            }
            current = current.next;
        }
        System.out.println("Song not found : " + title);
    }

    // PLAY NEXT SONG

    public void playNext(Song currentSong) {
        if(currentSong.next != null) {
            System.out.println("Now playing : " + currentSong.next.title + " By " + currentSong.next.artist);
        } else {
            System.out.println("END OF PLAYLIST");
        }
    }

    // PLAY PREVIOUS SONG

    public void playPrevious(Song currentSong) {
        if(currentSong.prev != null) {
            System.out.println("Now playing : " + currentSong.next.title + " By " + currentSong.next.artist);
        } else {
            System.out.println("Start of playlist reached: ");
        }
    }
}

public class MusicPlaylistMnager {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Song A", "Artist A");
        playlist.addSong("Song B", "Artist B");
        playlist.addSong("Song C", "Artist C");

        playlist.displaylist();
        playlist.playSong("Song B");
        playlist.removeSong("Song A");
        playlist.displaylist();
    }
}
