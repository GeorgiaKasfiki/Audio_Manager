package grAudioManager.app;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaManager {

    private ArrayList<Media> mediaList = new ArrayList<>();

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public void removeMedia(int index){
        if(index >= 0 && index < mediaList.size()){
            mediaList.remove(index);
        }
    }

    public void displayMedia() {
        if(mediaList.size() ==0){
            System.out.println("The list is empty.");
        }else {
            for (Media m : mediaList) {
                System.out.println(m);
            }
        }
    }

    public void clearMedia() {
        mediaList.clear();
    }

    public float getTotalCost() {
        float totalPrice = 0;
        for(Media m : mediaList){
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }

    public int getTotalSize(){
        int totalSize = 0;
        for (Media m : mediaList){
            totalSize += m.getSize();
        }
        return totalSize;
    }

    public int getTotalDuration(){
        int totalDuration = 0;
        for(Media m : mediaList){
            totalDuration += m.getDuration();
        }
        return totalDuration;
    }

    public void saveMediaList(String filename) {
        try {
            PrintWriter printWriter = new PrintWriter( new File(filename));
            for(Media m : mediaList){
                printWriter.println(m.getType()+", "+ m.getName()+ ", "+m.getSize()+ ", "
                                    + m.getDuration()+", "+ m.getPrice());
            }
            printWriter.close();
        }catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved.");
        }
    }

    public void loadMediaList(String filename){
        try{
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Media media = new Audio(words[0], words[1],Integer.parseInt(words[2]), Integer.parseInt(words[3]),
                                        Float.parseFloat(words[4]), "Artist's name" );
                mediaList.add(media);
            }
        }catch(Exception e){}
    }
}
