package lab11;

public class MediaInterested implements Observer {
    private String name;

    public MediaInterested(String name) {
        this.name = name;
    }

    public void doSomeLogic(String videoTitle) {
        System.out.println(name + " procesează informația despre: " + videoTitle);
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " a fost notificat: video nou -> " + videoTitle);
    }
}