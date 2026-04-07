abstract class Media {
    private String title;
    private String artist;

    public Media(String title, String artist) {
        this.title           = title;
        this.artist          = artist;
    }

    // Getters & Setters
    public String getTitle()                       { return title; }
    public String getArtist()                      { return artist; }
    public void   setTitle(String title)           { this.title = title; }
    public void   setArtist(String artist)         { this.artist = artist; }
    // Abstract — every Media subclass must define how it plays
    public abstract void play();

    @Override
    public String toString() {
        return "Title    : " + title +
               "\nArtist   : " + artist ;
    }
}


abstract class AudioMedia extends Media {
    private int    volume;     
    private String audioFormat; 

    public AudioMedia(String title, String artist,
                      int volume, String audioFormat) {
        super(title, artist);
        this.volume      = volume;
        this.audioFormat = audioFormat;
    }

    public int    getVolume()                   { return volume; }
    public String getAudioFormat()              { return audioFormat; }
    public void   setVolume(int volume)         { this.volume = Math.min(100, Math.max(0, volume)); }
    public void   setAudioFormat(String fmt)    { this.audioFormat = fmt; }


    public abstract void adjustVolume(int delta);

    @Override
    public String toString() {
        return super.toString() +
               "\nVolume   : " + volume +
               "\nFormat   : " + audioFormat;
    }
}


class MusicPlayer extends AudioMedia {
    private String  playlistName;
    private boolean isShuffle;
    private boolean isRepeat;

    public MusicPlayer(String title, String artist,
                       int volume, String audioFormat,
                       String playlistName, boolean isShuffle, boolean isRepeat) {
        super(title, artist, volume, audioFormat);
        this.playlistName = playlistName;
        this.isShuffle    = isShuffle;
        this.isRepeat     = isRepeat;
    }

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

public class MediaSystem {


    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Enter MusicPlayer details:");
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Artist: ");
        String artist = sc.nextLine();

        System.out.print("Volume (0-100): ");
        int volume = sc.nextInt();
        sc.nextLine();
        System.out.print("Audio format: ");
        String format = sc.nextLine();

        System.out.print("Playlist name: ");
        String playlist = sc.nextLine();
        System.out.print("Shuffle (true/false): ");
        boolean shuffle = sc.nextBoolean();

        System.out.print("Repeat (true/false): ");
        boolean repeat = sc.nextBoolean();

        MusicPlayer player = new MusicPlayer(
                title, artist,
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

        System.out.println(player);



        sc.close();
    }
}