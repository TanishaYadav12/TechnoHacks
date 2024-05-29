import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum Choice {
    ROCK, PAPER, SCISSORS;

    public static Choice getRandomChoice() {
        return values()[(int) (Math.random() * values().length)];
    }
}

class Game {
    public static String determineWinner(Choice player, Choice computer) {
        if (player == computer) {
            return "It's a tie!";
        }

        switch (player) {
            case ROCK:
                return (computer == Choice.SCISSORS) ? "Player wins!" : "Computer wins!";
            case PAPER:
                return (computer == Choice.ROCK) ? "Player wins!" : "Computer wins!";
            case SCISSORS:
                return (computer == Choice.PAPER) ? "Player wins!" : "Computer wins!";
        }

        return "Invalid game state!";
    }
}

public class RockPaperScissorsGame extends JFrame {
    private JLabel resultLabel;
    private JLabel playerChoiceLabel;
    private JLabel computerChoiceLabel;

    public RockPaperScissorsGame() {
        setTitle("Rock Paper Scissors");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");

        resultLabel = new JLabel("Make your choice!", SwingConstants.CENTER);
        playerChoiceLabel = new JLabel("Your choice: ", SwingConstants.CENTER);
        computerChoiceLabel = new JLabel("Computer choice: ", SwingConstants.CENTER);

        rockButton.addActionListener(new ChoiceListener(Choice.ROCK));
        paperButton.addActionListener(new ChoiceListener(Choice.PAPER));
        scissorsButton.addActionListener(new ChoiceListener(Choice.SCISSORS));

        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);
        panel.add(playerChoiceLabel);
        panel.add(computerChoiceLabel);
        panel.add(resultLabel);

        add(panel);
    }

    private class ChoiceListener implements ActionListener {
        private Choice playerChoice;

        public ChoiceListener(Choice choice) {
            playerChoice = choice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Choice computerChoice = Choice.getRandomChoice();
            String result = Game.determineWinner(playerChoice, computerChoice);

            playerChoiceLabel.setText("Your choice: " + playerChoice);
            computerChoiceLabel.setText("Computer choice: " + computerChoice);
            resultLabel.setText(result);

            // Add animation here
            animateChoice(playerChoice, computerChoice);
        }
    }

    private void animateChoice(Choice playerChoice, Choice computerChoice) {
        // Simple animation: flash the result label
        Timer timer = new Timer(100, new ActionListener() {
            int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < 6) {
                    resultLabel.setVisible(!resultLabel.isVisible());
                    count++;
                } else {
                    ((Timer) e.getSource()).stop();
                    resultLabel.setVisible(true);
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RockPaperScissorsGame game = new RockPaperScissorsGame();
            game.setVisible(true);
        });
    }
}
