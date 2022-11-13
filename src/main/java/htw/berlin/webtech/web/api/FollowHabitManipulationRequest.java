package htw.berlin.webtech.web.api;

public class FollowHabitManipulationRequest {


    private String title;
    private String description;
    private String category;
    private Boolean finished;
    private Long superhabitId;


    public FollowHabitManipulationRequest(String title, String description, String category, Boolean finished, Long superhabitId) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.finished = finished;
        this.superhabitId = superhabitId;
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

    public Long getSuperhabitId() {
        return superhabitId;
    }

    public void setSuperhabitId(Long superhabitId) {
        this.superhabitId = superhabitId;
    }
}
