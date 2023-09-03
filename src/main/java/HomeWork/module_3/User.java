package HomeWork.module_3;

import java.io.Serializable;
import java.util.Objects;

public class User<T> implements Serializable {

    private T name;
    private T login;
    private int age;
    private String  hobby;

    public User(){}

    public User(T name, T login, int age, String hobby){
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobby = hobby;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getLogin() {
        return login;
    }

    public void setLogin(T login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        String[] hobbes = hobby.trim().split(",");
        StringBuilder formatHobby = new StringBuilder();
        for (String el: hobbes)
            formatHobby.append(el).append("\n");
        return
                "Пользователь : " + name +
                " с логином: " + login +
                ". Его возраст: " + age +
                ". Все хобби: " +"\n" + formatHobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User<?> user = (User<?>) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(login, user.login) && Objects.equals(hobby, user.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, age, hobby);
    }
}

