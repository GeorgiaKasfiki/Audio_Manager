package grAudioManager.app;

public class Picture extends Media{

    String photographer;

    public Picture (String type, String name, int size, int duration, float price, String photographer){
        super (type, name, size, duration, price);
        this.photographer = photographer;
    }

//set
    public void setPhotographer(String photographer) {this.photographer = photographer; }

//get
    public String getPhotographer(){ return photographer; }

//toString
    @Override
    public String toString(){
        return super.toString()+ "\nPhotographer's name is "+photographer+".";
    }

}
