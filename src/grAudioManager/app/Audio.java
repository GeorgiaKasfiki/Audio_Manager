package grAudioManager.app;

public class Audio extends Media {

    private String singer;

    public Audio (String type, String name, int size, int duration, float price, String singer){
        super (type, name, size, duration, price);
        this.singer = singer;
    }
//set
    public void setSinger(String singer){ this. singer = singer; }

//get
    public String getSinger() { return singer; }

//toString
    @Override
    public String toString() {
        return super.toString()
                +"\nSinger's name is " +singer+ ".";
    }

}