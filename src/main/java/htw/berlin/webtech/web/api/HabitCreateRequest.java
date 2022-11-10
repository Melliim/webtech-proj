package htw.berlin.webtech.web.api;

public class HabitCreateRequest {

    private String title;
    private String description;
    private boolean finished;


    public HabitCreateRequest(String title, String description, boolean finished) {
        this.title = title;
        this.description = description;
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
