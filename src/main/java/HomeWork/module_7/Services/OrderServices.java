package HomeWork.module_7.Services;

import HomeWork.module_7.DAO.OrderDAO;
import HomeWork.module_7.DAO.UserDAO;
import HomeWork.module_7.Models.Order;
import HomeWork.module_7.Models.User;

import java.util.List;

import static HomeWork.module_7.Services.UserServices.findByName;

public class OrderServices {

    public static void addOrder (Order order, String userName) {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.findByName(userName);
        for (User el : users) {
            el.addOrder(order);
            userDAO.update(el.getId(), el);
        }
    }
}
