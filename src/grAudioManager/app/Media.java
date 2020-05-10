package grAudioManager.app;

public abstract class Media {
    private String type, name;
    private int size;
    private int duration;
    private float price;

//setters
    public void setType(String type) { this.type = type; }

    public void setName(String name) { this.name = name; }

    public void setDuration(int duration) { this.duration = duration; }

    public void setPrice(float price) { this.price = price; }

    public void setSize(int size){ this.size = size; }
//getters
    public String getType() { return type; }

    public String getName() { return name; }

    public int getDuration() { return duration; }

    public float getPrice() { return price; }

    public int getSize() { return  size; }

// constractor

    public Media(String type, String name, int size, int duration, float price) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.duration = duration;
        this.price = price;
    }

    @Override
    public String toString(){
        return "This media is" +type+ " type. \n"
                +"Its name is " +name+ ". \n"
                +"Its size is "+ size+"\n"
                +"Its duration is " + duration + ". \n"
                +"It costs " +price+ "$.";
    }






}