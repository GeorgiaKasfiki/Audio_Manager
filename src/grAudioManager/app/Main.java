package grAudioManager.app;

public class Main {

    public static void main(String[] args){
        UI userInterface = new UI();
        MediaManager manager = new MediaManager();
        userInterface.manageMediaList(manager);
    }

}
