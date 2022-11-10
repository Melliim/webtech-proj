package htw.berlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "habits_")
public class HabitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private long id;

    @Column(name = "title_", nullable = false)
    private String title;

    @Column(name = "description_", nullable = false)
    private String description;

    @Column(name = "is_finished_")
    private boolean finished;

    /*@Column(name = ".test")
    private String testColumn;*/

    public HabitEntity(String title, String description, boolean finished) {
        this.title = title;
        this.description = description;
        this.finished = finished;
    }

    protected HabitEntity() {
    }

    public long getId() {
        return id;
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

   /*public String getTestColumn() {
        return testColumn;
    }

    public void setTestColumn(String testColumn) {
        this.testColumn = testColumn;
    }*/
}
