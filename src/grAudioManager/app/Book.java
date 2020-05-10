package grAudioManager.app;

public class Book extends Media{

    String author;
    public Book (String type, String name, int size, int duration, float price, String author){
        super (type, name, size, duration, price);
        this.author = author;
    }

//set
    public void setAuthor(String author) {this.author = author; }

//get
    public String getAuthor() { return author; }

//toString
    @Override
    public String toString(){
        return super.toString()+ "\nAuthor's name is "+author+".";
    }

}
