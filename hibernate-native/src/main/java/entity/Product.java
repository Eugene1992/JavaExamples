package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product extends Model{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    private Employee employee;

    public Product() {
        super();
    }

    public Product(Long id) {
        super(id);
    }

    public Product(String description, BigDecimal price) {
        this.title = description;
        this.price = price;
    }

    public String getDescription() {
        return title;
    }

    public void setDescription(String description) {
        this.title = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
