package lab11;

public class Main {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel("Canal YouTube");

        MediaInterested media1 = new MediaInterested("MediaInterested 1");
        MediaInterested media2 = new MediaInterested("MediaInterested 2");

        channel.registerObserver(media1);
        channel.registerObserver(media2);

        channel.uploadVideo("Primul video");

        channel.unregisterObserver(media2);

        channel.uploadVideo("Al doilea video");
    }
}