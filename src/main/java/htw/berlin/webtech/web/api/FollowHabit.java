package htw.berlin.webtech.web.api;

public class FollowHabit {

    private Long id;
    private String title;
    private String description;
    private String category;
    private Boolean finished;
    private Habit habit;



    public FollowHabit(Long id, String title, String description, String category, Boolean finished, Habit habit) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.finished = finished;
        this.habit = habit;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }
}
