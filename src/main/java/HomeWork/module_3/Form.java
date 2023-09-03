package HomeWork.module_3;

import java.io.*;
import java.util.Scanner;

public class Form {

    public static void addUser() {
        User<String> user = new User<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        user.setName(scanner.nextLine());
        System.out.println("Введите логин: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Введите возраст: ");
        user.setAge(scanner.nextInt());
        System.out.println("Введите хобби через запятую: ");
        scanner.nextLine();
        user.setHobby(scanner.nextLine());
        serialization(user);

    }

    public static<T> void serialization(User<T> user) {
        try {
            FileOutputStream  fos = new FileOutputStream("userData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static<T> User deserialization() {
        User<T> user = new User<T>();
        try {
            FileInputStream fis = new FileInputStream("userData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            user = (User<T>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    public static void main(String[] args) {
        addUser();
        deserialization();
    }
}
