package htw.berlin.webtech.persistence;



        import javax.persistence.*;

@Entity(name = "followHabits")
public class FollowHabitEntity {

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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "superhabit_id", referencedColumnName = "id")
    private HabitEntity superhabit;


    public FollowHabitEntity() {
    }

    public FollowHabitEntity(String title, String description, Boolean finished, Category category, HabitEntity superhabit) {
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.category = category;
        this.superhabit = superhabit;
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

    public HabitEntity getSuperhabit() {
        return superhabit;
    }

    public void setSuperhabit(HabitEntity superhabit) {
        this.superhabit = superhabit;
    }
}