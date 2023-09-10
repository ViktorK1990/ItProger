package HomeWork.module_7;

import HomeWork.module_7.Models.Order;
import HomeWork.module_7.Models.User;
import HomeWork.module_7.Services.OrderServices;
import HomeWork.module_7.Services.UserServices;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user = new User("Margarita", 30);
        Order order = new Order("Phone", 1500);
        user.addOrder(order);
        UserServices.saveUser(user);

        User user1 = new User("Gleb", 45);
        UserServices.saveUser(user1);

        Order order1 = new Order("Fridge", 3000);
        Order order2 = new Order("TV", 2000);
        Order order3 = new Order("Table", 2500);
        OrderServices.addOrder(order1, "Gleb");
        OrderServices.addOrder(order2, "Gleb");
        OrderServices.addOrder(order3, "Gleb");

    }
}
