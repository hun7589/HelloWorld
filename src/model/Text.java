package src.model;

public class Text {
    private int id;
    private String title;
    private String content;

    public Text(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
}
