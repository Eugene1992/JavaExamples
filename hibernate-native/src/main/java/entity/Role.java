package entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role extends Model{

    @Column(name = "title")
    private String title;

    @OneToOne
    private Employee employee;

    public Role() {
        super();
    }

    public Role(Long id) {
        super(id);
    }

    public Role(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

