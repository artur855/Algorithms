package Others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {

		int lives = 5;
		Random rm = new Random();
		Scanner sn = new Scanner(System.in);
		String[] words = { "word", "house", "desk", "dinner", "school", "computer", "hangman" };
		String word = words[rm.nextInt(words.length)];
		StringBuilder builder = new StringBuilder(String.join("", Collections.nCopies(word.length(), "-")));
		List<Character> guessed = new ArrayList<>();
		System.out.println("This is the hangman game!");
		while (true) {
			System.out.println("You have " + lives + " chances remaining!\nProgress: " + builder.toString()
					+ "\nLetters guessed before: " + guessed.toString() + "\nGuess a letter:");
			char guess = sn.next().toLowerCase().charAt(0);
			if (!Character.isLetter(guess)) {
				System.out.println("You can only guess letters");
			} else if (guessed.contains(guess)) {
				System.out.println("You already guessed that letter");
			} else if (word.indexOf(guess) < 0) {
				System.out.println("The word doesn't contain that letter");
				lives--;
			} else {
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == guess) {
						builder.setCharAt(i, guess);
					}
				}

			}
			if (builder.toString().equals(word)) {
				System.out.println("Congratulations!!\nYou guessed the word '" + word + "' correctly!\nYou took "
						+ guessed.size() + " guesses!");
				break;
			}
			if (lives == 0) {
				System.out.println("\nYou lost :(\nThe word was '" + word + "'\nBetter luck next time!");
				break;
			}
			if (!guessed.contains(guess)) {
				guessed.add(guess);
			}
			Collections.sort(guessed);
		}
		sn.close();

	}

}
