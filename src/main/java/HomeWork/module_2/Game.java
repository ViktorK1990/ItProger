package HomeWork.module_2;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements PlayInterface {
    ArrayList<Player> players = new ArrayList<>();

    @Override
    public void play() {
        System.out.println("""
                Добро пожаловать !!!
                Выберите режим игры:\s
                1. Игрок против игрока
                2. Играть с ботом
                3. Выход""");
        System.out.print("Ваш выбор: ");

        Scanner scanner = new Scanner(System.in);
        byte choice = scanner.nextByte();
        switch (choice) {
            case 1 -> playWithPlayer();
            case 2 -> playWithBot();
            case 3 -> {
                return;
            }
            default -> play();
        }
    }


    @Override
    public void whoWins() {
        System.out.println("Нажмите Enter чтобы начать");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        if (players.get(0).getChoice().equals(players.get(1).getChoice())) {
            System.out.println("Игра завершилась ничьей!");
        }
        else if ((players.get(0).getChoice().equals(VARIANTS.STONE) && players.get(1).getChoice().equals(VARIANTS.SCISSORS)) ||
                (players.get(0).getChoice().equals(VARIANTS.SCISSORS) && players.get(1).getChoice().equals(VARIANTS.PAPER)) ||
                (players.get(0).getChoice().equals(VARIANTS.PAPER) && players.get(1).getChoice().equals(VARIANTS.STONE))) {
            System.out.println("Победил игрок с именем: " + players.get(0).getName() + "!");
        } else {
            System.out.println("Победил игрок с именем: " + players.get(1).getName() + "!");
        }
    }


    private void playWithBot() {
        players.add(new Player("Bot", VARIANTS.randomVariants()));
        playWithPlayer();
    }


    private void playWithPlayer() {
        System.out.println("Введите имя игрока: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("""
                Cделайте выбор: \s
                1. Камень
                2. Ножницы
                3. Бумага""");
        System.out.print("Ваш выбор: ");
        byte choice = scanner.nextByte();
        addPlayer(name, choice);
    }



    private void addPlayer(String name, byte choice) {
        if (name.equals("")) {
            System.out.println("Неверно введено имя");
            playWithPlayer();
        }
        switch (choice) {
            case 1 -> players.add(new Player(name, VARIANTS.STONE));
            case 2 -> players.add(new Player(name, VARIANTS.SCISSORS));
            case 3 -> players.add(new Player(name, VARIANTS.PAPER));
            default -> {
                System.out.println("Неверный выбор");
                playWithPlayer();
            }
        }
        if (players.size() == 2) {
            whoWins();
        } else {
            playWithPlayer();
        }

    }


    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
