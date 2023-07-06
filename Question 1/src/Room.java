public class Room {
    // Declaring private instance variables
    private String block;
    private String level;
    private String no;

    // Defining a constructor with parameters
    public Room(String block, String level, String no) {
        this.block = block;
        this.level = level;
        this.no = no;
    }

    // Defining a setter method to update the object's state
    public void setRoom(String block, String level, String no) {
        this.block = block;
        this.level = level;
        this.no = no;
    }

    // Defining getter methods to access the object's state
    public String getBlock() {
        return block;
    }

    public String getLevel() {
        return level;
    }

    public String getNo() {
        return no;
    }
}