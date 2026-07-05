interface Sports {
    void play();
}

class Cricket implements Sports {
    @Override
    public void play() {
        System.out.println("Playing Cricket with bat and ball.");
    }
}

public class SportsCricket {
    public static void main(String[] args) {
        Sports cricket = new Cricket();
        cricket.play();
    }
}