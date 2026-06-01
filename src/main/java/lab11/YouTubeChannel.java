package lab11;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {
    private String channelName;
    private List<Observer> observers;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String videoTitle) {
        for (Observer observer : observers) {
            observer.update(videoTitle);
        }
    }

    public void uploadVideo(String videoTitle) {
        System.out.println(channelName + " a încărcat video-ul: " + videoTitle);
        notifyObservers(videoTitle);
    }
}
