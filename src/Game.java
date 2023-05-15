import java.security.SecureRandom;
import java.util.Scanner;

public class Game {
    public int prizeDoor;
    public int chosenDoor;
    public int iteration;
    public boolean change;
    public Door[] doorList = new Door[3];
    public static SecureRandom rand = new SecureRandom();
    public static Scanner input = new Scanner(System.in);
    public static int wins;
    public static int losses;

    public Game() {
        initGame();
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.inputChoice();
        game.inputIteration();

        for (int i = game.iteration; i > 0; i--) {
            game.runGame();
        }

        System.out.println("Wins: " + wins + "\nLosses: " + losses);
    }

    public void runGame() {
        // choose door at random
        this.chooseDoor();
        this.revealDoor();
        this.changeDoor();
        this.gameResult();
        this.initGame();
    }

    public void initGame() {
        prizeDoor = rand.nextInt(3);

        // init doors
        for (int i = 0; i < 3; i++) {
            doorList[i] = new Door((prizeDoor == i) ? true : false);
            // System.out.println("Door " + i + " initialized");
        }

        // System.out.println("Prize door is: " + prizeDoor);

        // change revealability of door with prize
        doorList[prizeDoor].revealable = false;

        // System.out.println("Game initiated");
    }

    // get input for changing choice
    public void inputChoice() {
        System.out.print("Will you change doors in this simulation? (Y/N): ");
        String choiceStr = input.next().toLowerCase();
        change = choiceStr.equals("y");
    }

    public void inputIteration() {
        System.out.print("How many rounds should this session simulate? : ");
        this.iteration = input.nextInt();
    }

    public void editChoosable(int doorNum, boolean val) {
        this.doorList[doorNum].choosable = val;
    }

    public void chooseDoor() {
        this.chosenDoor = rand.nextInt(3);
        editChoosable(chosenDoor, false);
        doorList[chosenDoor].revealable = false;

        // System.out.println("Chosen door: " + chosenDoor);
    }

    // reveals door making one of empty doors unchoosable
    public void revealDoor() {
        int revealNum = 0;

        for (int i = 0; i < 3; i++) {
            if (this.doorList[i].revealable) {
                // System.out.println("Reveal door found at: " + i);
                revealNum = i;
                break;
            }
        }

        doorList[revealNum].choosable = false;
        // System.out.println("Revealed door: " + revealNum);
    }

    // change or maintains chosen door according to input value
    public void changeDoor() {
        if (change) {
            int newDoor = 0;

            for (int i = 0; i < 3; i++) {
                if (this.doorList[i].choosable) {
                    newDoor = i;
                    break;
                }
            }

            chosenDoor = newDoor;
            // System.out.println("Chosen door changed to: " + chosenDoor);
        }
    }

    public void gameResult() {
        if (chosenDoor == prizeDoor) {
            wins++;
        } else {
            losses++;
        }
    }
}