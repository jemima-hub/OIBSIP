package guessgame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class GuessNumberGame extends JFrame implements ActionListener {

    JLabel title, message, attemptsLabel, scoreLabel;

    JTextField input;

    JButton guessButton, restartButton;

    int randomNumber;

    int attempts;

    int score;

    public GuessNumberGame() {

        setTitle("Number Guessing Game");

        setSize(450, 350);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title = new JLabel("Guess Number (1 - 100)");
        title.setBounds(120, 20, 250, 30);

        message = new JLabel("Enter your guess");
        message.setBounds(140, 60, 250, 30);

        input = new JTextField();
        input.setBounds(120, 100, 180, 35);

        guessButton = new JButton("Guess");
        guessButton.setBounds(150, 150, 120, 35);

        attemptsLabel = new JLabel("Attempts Left: 5");
        attemptsLabel.setBounds(140, 200, 200, 30);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(170, 230, 150, 30);

        restartButton = new JButton("New Game");
        restartButton.setBounds(140, 260, 150, 35);

        add(title);

        add(message);

        add(input);

        add(guessButton);

        add(attemptsLabel);

        add(scoreLabel);

        add(restartButton);

        guessButton.addActionListener(this);

        restartButton.addActionListener(this);

        startGame();

        setVisible(true);
    }

    void startGame() {

        randomNumber =
                new Random().nextInt(100) + 1;

        attempts = 5;

        score = 0;

        attemptsLabel.setText(
                "Attempts Left: " + attempts);

        scoreLabel.setText(
                "Score: " + score);

        message.setText(
                "Enter your guess");

        input.setText("");
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == restartButton) {

            startGame();

            return;
        }

        try {

            int guess =
                    Integer.parseInt(
                            input.getText());

            attempts--;

            attemptsLabel.setText(
                    "Attempts Left: "
                            + attempts);

            if (guess == randomNumber) {

                score =
                        attempts * 10 + 10;

                scoreLabel.setText(
                        "Score: "
                                + score);

                JOptionPane.showMessageDialog(
                        this,
                        "Correct! You Won!");

                startGame();

            }

            else if (guess < randomNumber) {

                message.setText(
                        "Too Low");

            }

            else {

                message.setText(
                        "Too High");

            }

            if (attempts == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Game Over!\nNumber was: "
                                + randomNumber);

                startGame();

            }

            input.setText("");

        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter valid number");

        }

    }

    public static void main(
            String[] args) {

        new GuessNumberGame();

    }

}