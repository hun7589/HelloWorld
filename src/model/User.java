package src.model;

public class User {
    private int id;
    private String uname;

    public User(int id, String uname) {
        this.id = id;
        this.uname = uname;
    }

    public int getId() { return id; }
    public String getUname() { return uname; }
}
