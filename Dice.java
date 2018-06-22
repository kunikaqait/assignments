package DiceFunction;

import java.util.Scanner;

public class Dice {

    int numberOfSides;

    public Dice(int numberofSides) {
        if (numberofSides < 2 || numberofSides == 3 || numberofSides == 5 || numberofSides > 6) {
            System.out.println("Invalid Input");
            System.exit(0);
        } else {
            this.numberOfSides = numberofSides;
        }
    }

    public String rollDice() {
        int rand = 1 + (int)(Math.random() * numberOfSides);
        String result = null;
        if (numberOfSides == 2) {
            switch(rand) {
                case 1 : result = "HEAD";
                    break;
                case 2 : result = "TAIL";
                    break;
            }
        } else {
            result = String.valueOf(rand);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of Sides between 2, 4 & 6: ");
        Scanner scanner = new Scanner(System.in);
        int sides = scanner.nextInt();
        Dice userDice = new Dice(sides);
        int choice;
        do {
            System.out.println(userDice.rollDice());
            System.out.println("Do you want to roll again(1 --> yes, 0 --> no): ");
            choice = scanner.nextInt();
        } while(choice == 1);
        scanner.close();
    }

}