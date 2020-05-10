package grAudioManager.app;

public class Movie extends Media {

    String producer;

    public Movie (String type, String name, int size, int duration, float price, String producer){
        super (type, name, size, duration, price);
        this.producer = producer;
    }

//set
    public void setProducer(String producer) { this.producer = producer; }

//get
    public String getProducer() {return producer; }

//toString
    @Override
    public String toString(){
        return super.toString()+ "\nProducer's name is "+producer+ ".";
    }

}
