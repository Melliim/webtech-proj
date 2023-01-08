package htw.berlin.webtech.web.api;

import java.util.List;

public class Habit {

    private Long id;
    private String title;
    private String description;
    private String category;
    private Boolean finished;
    private List<Long> followHabits;

    public Habit(Long id, String title, String description, String category, Boolean finished, List<Long> followHabits) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.finished = finished;
        this.followHabits = followHabits;
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

    public Boolean getFinished() {
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

    public List<Long> getFollowHabits() {
        return followHabits;
    }

    public void setFollowHabits(List<Long> followHabits) {
        this.followHabits = followHabits;
    }
}
