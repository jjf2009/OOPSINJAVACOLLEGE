abstract class MediaContent {
    String artistName;

    MediaContent(String artistName) {
        this.artistName = artistName;
    }

    abstract String getGenre();
}

class Song extends MediaContent {
    int[] durations = new int[5]; // seconds

    Song(String artistName, int[] durations) {
        super(artistName);
        this.durations = durations;
    }

    String getGenre() {
        return "Pop";
    }

    int getTotalDuration() {
        int sum = 0;
        for (int d : durations) {
            sum += d;
        }
        return sum;
    }

    String formatArtistName() {
        String name = artistName.trim();
        if (name.contains(" ")) {
            System.out.println("Full name (first + last)");
        } else {
            System.out.println("Single name only");
        }
        return name;
    }

    void checkPlaylist() {
        if (getTotalDuration() > 1200) {
            System.out.println("Long Playlist");
        } else {
            System.out.println("Short Playlist");
        }
    }
}

public class MusicPlaylistManager {
    public static void main(String[] args) {
        int[] d = {200, 180, 250, 300, 220};
        Song song = new Song("  Taylor Swift  ", d);

        // polymorphism
        MediaContent ref = song;
        System.out.println("Genre: " + ref.getGenre());
        System.out.println("Artist: " + song.formatArtistName());
        System.out.println("Total duration: " + song.getTotalDuration() + " sec");
        song.checkPlaylist();
    }
}
