import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Colors {
    public static void main(String[] args) {
        File file = new File("src/colors.txt");
        Scanner read;
        try {
        	// Read and display colors from file.
            read = new Scanner(file);
            System.out.println("There are sixteen colors in the file:");
            while (read.hasNextLine()) {
                String color = read.nextLine();
                System.out.println(color);
            }
            read.close();
            
        } catch (FileNotFoundException e) {
        	//If file cannot be found, catch exception.
            System.out.println("File was not found.");
        }
        int round;
        int roundsWon = 0;
        
        
        for (round = 1; round <= 16; round++) {
        	Scanner input = new Scanner(System.in);
        	Random random = new Random();
        	int min = 1;
        	int max = 16;
        	int randomColors = random.nextInt((max - min) + 1) + 1;
        	
        	// Pick a random color and let the user guess it using numbers.
        	System.out.println("");
        	System.out.println("Round " + round);
        	System.out.println("I am thinking of one of these colors.");
        	System.out.println("Can you guess what it is?");
        	System.out.print("Enter your guess using an integer: ");
        	int guess = input.nextInt();
        	// If the user picks a number not in the range, tell them to pick a number in the range.
        	while (guess < 1 || guess > 16) {
    			System.out.print("Invalid number. Please enter a number in the range 1 through 16: ");
    			guess = input.nextInt();
    		}
        	if (guess == randomColors) {
        		// Increase the user's score if they get it right.
        		System.out.println("Correct! I was thinking of " + randomColors);
        		roundsWon++;
        	}
        	else {
        		// Once they get it wrong, end the game.
        		System.out.println("Incorrect! I was thinking of " + randomColors);
        		System.out.println("");
        		System.out.println("Game Over");
        		break;
        	}
        }
        // Display the user's score.
        System.out.println("You have guessed correctly " + roundsWon + " times");
		return;
     
    }
}

