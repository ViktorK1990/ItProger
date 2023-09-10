package HomeWork.module_7.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public User() {}

    public User (String username, int age) {
        this.username = username;
        this.age = age;
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        order.setUser(this);
        orders.add(order);
    }

    public Order getLastOrder() {
        return orders.get(orders.size() -1);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User: " +
                "with id: " + id +
                ", name: " + username +
                ", age: " + age + "\n" +
                "Orders: " + orders;
    }
}
