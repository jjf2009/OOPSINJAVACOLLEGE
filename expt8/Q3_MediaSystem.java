// Q3. Multi-Level Media System – Abstract Class Chain

// Level 1 — Abstract base
abstract class Media {
    private String title;
    private String artist;
    private double durationMinutes;

    public Media(String title, String artist, double durationMinutes) {
        this.title           = title;
        this.artist          = artist;
        this.durationMinutes = durationMinutes;
    }

    // Getters & Setters
    public String getTitle()                       { return title; }
    public String getArtist()                      { return artist; }
    public double getDurationMinutes()             { return durationMinutes; }
    public void   setTitle(String title)           { this.title = title; }
    public void   setArtist(String artist)         { this.artist = artist; }
    public void   setDurationMinutes(double d)     { this.durationMinutes = d; }

    // Abstract — every Media subclass must define how it plays
    public abstract void play();

    @Override
    public String toString() {
        return "Title    : " + title +
               "\nArtist   : " + artist +
               String.format("%nDuration : %.2f mins", durationMinutes);
    }
}

// Level 2 — Abstract subclass; adds its own abstract method
abstract class AudioMedia extends Media {
    private int    volume;     // 0–100
    private String audioFormat; // MP3, FLAC, WAV, etc.

    public AudioMedia(String title, String artist, double durationMinutes,
                      int volume, String audioFormat) {
        super(title, artist, durationMinutes);
        this.volume      = volume;
        this.audioFormat = audioFormat;
    }

    // Getters & Setters
    public int    getVolume()                   { return volume; }
    public String getAudioFormat()              { return audioFormat; }
    public void   setVolume(int volume)         { this.volume = Math.min(100, Math.max(0, volume)); }
    public void   setAudioFormat(String fmt)    { this.audioFormat = fmt; }

    // Abstract — concrete class decides how volume adjustment behaves
    public abstract void adjustVolume(int delta);

    @Override
    public String toString() {
        return super.toString() +
               "\nVolume   : " + volume +
               "\nFormat   : " + audioFormat;
    }
}

// Level 3 — Concrete class; implements both abstract methods
class MusicPlayer extends AudioMedia {
    private String  playlistName;
    private boolean isShuffle;
    private boolean isRepeat;

    public MusicPlayer(String title, String artist, double durationMinutes,
                       int volume, String audioFormat,
                       String playlistName, boolean isShuffle, boolean isRepeat) {
        super(title, artist, durationMinutes, volume, audioFormat);
        this.playlistName = playlistName;
        this.isShuffle    = isShuffle;
        this.isRepeat     = isRepeat;
    }

    // Getters & Setters
    public String  getPlaylistName()              { return playlistName; }
    public boolean isShuffle()                    { return isShuffle; }
    public boolean isRepeat()                     { return isRepeat; }
    public void    setPlaylistName(String name)   { this.playlistName = name; }
    public void    setShuffle(boolean shuffle)    { this.isShuffle = shuffle; }
    public void    setRepeat(boolean repeat)      { this.isRepeat = repeat; }

    @Override
    public void play() {
        System.out.println("[MusicPlayer] Now Playing...");
        System.out.println("  Track    : " + getTitle() + " by " + getArtist());
        System.out.println("  Playlist : " + playlistName);
        System.out.println("  Format   : " + getAudioFormat());
        System.out.println("  Volume   : " + getVolume());
        System.out.println("  Shuffle  : " + (isShuffle ? "ON" : "OFF"));
        System.out.println("  Repeat   : " + (isRepeat  ? "ON" : "OFF"));
    }

    @Override
    public void adjustVolume(int delta) {
        int oldVolume = getVolume();
        setVolume(getVolume() + delta);   // setVolume clamps between 0–100
        System.out.println("[MusicPlayer] Volume: " + oldVolume +
                           " → " + getVolume() +
                           (getVolume() == 100 ? " (Max!)" : getVolume() == 0 ? " (Muted!)" : ""));
    }

    @Override
    public String toString() {
        return "[MusicPlayer]\n" + super.toString() +
               "\nPlaylist : " + playlistName +
               "\nShuffle  : " + isShuffle +
               "\nRepeat   : " + isRepeat;
    }
}

public class Q3_MediaSystem {
    private static boolean readBoolean(java.util.Scanner sc, String prompt) {
        System.out.print(prompt + " (true/false): ");
        String input = sc.nextLine().trim().toLowerCase();
        return input.equals("true") || input.equals("yes") || input.equals("y") || input.equals("1");
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Enter MusicPlayer details:");
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Artist: ");
        String artist = sc.nextLine();

        System.out.print("Duration (minutes): ");
        double duration = Double.parseDouble(sc.nextLine());

        System.out.print("Volume (0-100): ");
        int volume = Integer.parseInt(sc.nextLine());

        System.out.print("Audio format: ");
        String format = sc.nextLine();

        System.out.print("Playlist name: ");
        String playlist = sc.nextLine();

        boolean shuffle = readBoolean(sc, "Shuffle");
        boolean repeat = readBoolean(sc, "Repeat");

        MusicPlayer player = new MusicPlayer(
                title, artist, duration,
                volume, format,
                playlist, shuffle, repeat
        );

        System.out.println("\n=== Media Details ===\n");
        System.out.println(player);

        System.out.println("\n=== play() — Level 1 Abstract Method ===\n");
        player.play();

        System.out.println("\n=== adjustVolume() — Level 2 Abstract Method ===\n");
        player.adjustVolume(20);
        player.adjustVolume(40);
        player.adjustVolume(-110);

        System.out.println("\n=== Polymorphism via Media reference ===\n");
        Media m = new MusicPlayer("Starboy", "The Weeknd", 3.52,
                60, "MP3", "Top Hits", false, true);
        m.play();

        player.setVolume(65);
        player.setShuffle(false);
        System.out.println("\n=== After Settings Update ===");
        System.out.println(player);

        sc.close();
    }
}