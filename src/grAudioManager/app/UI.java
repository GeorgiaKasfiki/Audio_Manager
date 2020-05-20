package grAudioManager.app;

import java.util.Scanner;

public class UI {

    public Choice menu(){

        Choice returnChoice;

        System.out.println("1. Add new media.\n2. Remove old media.\n3.Display media list." +
                            "\n4.Clear media list.\n5.Total cost.\n6. Total size.\n7.Total duration."+
                            "\n8. Average Duration"+"\n9. Save.\n10. Load list.\n11.Total records."+
                            "\n12. Find Media \n0. EXIT");
        int choice;

        Scanner scanner = new Scanner(System.in);
        try{
            choice = scanner.nextInt();
            switch (choice){
                case 1: return Choice.ADD;
                case 2: return Choice.REMOVE;
                case 3: return Choice.DISPLAY;
                case 4: return Choice.CLEAR;
                case 5: return Choice.TOTALCOST;
                case 6: return Choice.TOTALSIZE;
                case 7: return Choice.TOTALDURATION;
                case 8: return Choice.AVGDURATION;
                case 9: return Choice.SAVE;
                case 10: return Choice.LOAD;
                case 11: return Choice.TOTALRECORDS;
                case 12: return Choice.FIND;
                case 0: return Choice.EXIT;
                default: return Choice.ERROR;
            }
        }catch (Exception e){
            return Choice.ERROR;
        }
    }

//factory method
    public Media createMedia(){
        String type;
        String name;
        int size;
        int duration;
        float price;
        String singer;
        String producer;
        String photographer;
        String author;
        int mediaType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select 1. for AUDIO, 2. for MOVIE, 3. for PICTURE, 4. for BOOK.");
        mediaType = scanner.nextInt();

        System.out.println("Give media Type.");
        type = scanner.next();
        System.out.println("Give media Name.");
        name = scanner.next();
        System.out.println("Give media Size.");
        size = scanner.nextInt();
        System.out.println("Give media Duration.");
        duration = scanner.nextInt();
        System.out.println("Give media Price.");
        price = scanner.nextFloat();

        Media media;
        switch (mediaType) {
            case 1:
                System.out.println("Give Singer's name.");
                singer = scanner.next();
                media = new Audio(type, name, size, duration,price, singer);
                return media;
            case 2:
                System.out.println("Give Producer's name.");
                producer = scanner.next();
                media = new Movie(type, name, size, duration,price, producer);
                return media;
            case 3:
                System.out.println("Give Photographer's name.");
                photographer = scanner.next();
                media = new Picture(type, name, size, duration,price, photographer);
                return media;
            case 4:
                System.out.println("Give Author's name.");
                author = scanner.next();
                media = new Book(type, name, size, duration,price, author);
                return media;
            default: return null;
        }
    }

    public void manageMediaList(MediaManager manager){
        Choice choice;
        do{
            choice = menu();
            switch (choice){
                case ADD:
                    Media media = createMedia();
                    manager.addMedia(media);
                    break;
                case REMOVE:
                    System.out.println("Give an index to remove.");
                    Scanner scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    manager.removeMedia(index);
                    break;
                case DISPLAY:
                    System.out.println("\n ");
                    manager.displayMedia();
                    System.out.println("\n ");
                    break;
                case CLEAR:
                    manager.clearMedia();
                    break;
                case TOTALCOST:
                    System.out.println("The total cost is " +manager.getTotalCost()+ " €.\n");
                    break;
                case TOTALSIZE:
                    System.out.println("The total size is " +manager.getTotalSize()+" MB.\n");
                    break;
                case TOTALDURATION:
                    System.out.println("The total duration is " +manager.getTotalDuration()+" minutes.\n");
                    break;
                case AVGDURATION:
                    System.out.println("The average duration is " +manager.getAverageDuration()+ "mins. \n");
                    break;
                case SAVE:
                    manager.saveMediaList("MediaList.txt");
                    break;
                case LOAD:
                    manager.loadMediaList("MediaList.txt");
                    break;
                case TOTALRECORDS:
                    System.out.println("The total amount of records is " +manager.getTotalRecords() +"media files\n");
                case FIND:
                    manager.FindMedia();
                    break;
                case EXIT:
                case ERROR:
                    System.out.println("WRONG INPUT!");
                    break;
            }
        }while(choice !=Choice.EXIT);
    }


}