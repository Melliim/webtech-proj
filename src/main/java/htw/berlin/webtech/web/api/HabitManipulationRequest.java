package htw.berlin.webtech.web.api;

public class HabitManipulationRequest {

    private String title;
    private String description;
    private String category;
    private Boolean finished;


    public HabitManipulationRequest(String title, String description, String category, Boolean finished) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.finished = finished;
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
