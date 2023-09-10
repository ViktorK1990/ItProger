package HomeWork.module_7.Services;

import HomeWork.module_7.DAO.UserDAO;
import HomeWork.module_7.Models.User;

import java.util.List;

public class UserServices {

    public static void saveUser(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.add(user);
    }

    public static void updateUser(int id, User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.update(id, user);
    }

    public static List<User> findByName(String name) {
        UserDAO userDAO = new UserDAO();
        return userDAO.findByName(name);
    }

    public static List<User> sortByAge(int from, int up_to) {
        UserDAO userDAO = new UserDAO();
        return userDAO.sortByAge(from, up_to);
    }

    public static void deleteByName(String name) {
        UserDAO userDAO = new UserDAO();
        List<User> list = userDAO.findByName(name);
        for (User el : list) {
            userDAO.deleteById(el.getId());
        }
    }

    public static void deleteByAge(int from, int up_to) {
        UserDAO userDAO = new UserDAO();
        List<User> list = userDAO.sortByAge(from, up_to);
        for (User el : list) {
            userDAO.deleteById(el.getId());
        }
    }

    public static void deleteById(int id) {
        UserDAO userDAO = new UserDAO();
        userDAO.deleteById(id);
    }
}
