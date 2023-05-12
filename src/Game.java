import java.security.SecureRandom;
import java.util.Scanner;

public class Game {
    private int prizeDoor;
    private int chosenDoor;
    private boolean change;
    private Door[] doorList = new Door[3];

    public Game() {
        SecureRandom rand = new SecureRandom();

        change = false;
        prizeDoor = rand.nextInt(3);

        doorList[prizeDoor].unrevealable();
        for (int i = 0; i < 3; i++) {
            doorList[i] = new Door((prizeDoor == i) ? true : false);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        SecureRandom rand = new SecureRandom(null);
        Scanner input = new Scanner(System.in);

        System.out.print("Will you change doors in this simulation (Y/N): ");
        String choiceStr = input.next().toLowerCase();
        game.changeChoice(choiceStr.equals("y"));

        game.chooseDoor(rand.nextInt(3));
    }

    public void changeChoice(boolean choice) {
        this.change = choice;
    }

    public void chooseDoor(int doorNum) {
        this.chosenDoor = doorNum;
    }

    public void revealDoor() {

    }

    public void changeDoor(boolean change) {

    }
}