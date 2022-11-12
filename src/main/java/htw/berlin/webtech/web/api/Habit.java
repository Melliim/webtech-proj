package htw.berlin.webtech.web.api;

public class Habit {

    private Long id;
    private String title;
    private String description;
    private String category;
    private Boolean finished;

    public Habit(Long id, String title, String description,String category, Boolean finished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.finished = finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
