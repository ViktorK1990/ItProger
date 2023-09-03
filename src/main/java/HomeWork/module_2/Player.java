package HomeWork.module_2;

import java.sql.Struct;

public class Player {

    private String name;
    private VARIANTS choice;


    public Player(String name, VARIANTS choice){
        this.name = name;
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VARIANTS getChoice() {
        return choice;
    }

    public void setChoice(VARIANTS choice) {
        this.choice = choice;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", choice=" + choice +
                '}';
    }
}
