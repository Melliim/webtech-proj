package htw.berlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "habits")
public class HabitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "isFinished")
    private Boolean finished;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToOne(mappedBy = "superhabit")
    private FollowHabitEntity followHabit;

    /* @Column(name = ".test")
    private String testColumn; */

    public HabitEntity(String title, String description, Boolean finished, Category category) {
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.category = category;
    }

    protected HabitEntity() {
    }

    public Long getId() {
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

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public FollowHabitEntity getFollowHabit() {
        return followHabit;
    }

    public void setFollowHabit(FollowHabitEntity followHabit) {
        this.followHabit = followHabit;
    }

    /*public String getTestColumn() {
        return testColumn;
    }

    public void setTestColumn(String testColumn) {
        this.testColumn = testColumn;
    }*/
}
