import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    public StatisticsFrame(Player player) {
        setTitle("My Statistics");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only close this window, not the whole app
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Adding labels safely extracted from the current Player object
        add(new JLabel("Username:", SwingConstants.CENTER));
        add(new JLabel(player.getUsername(), SwingConstants.CENTER));

        add(new JLabel("Wins (+10 pts):", SwingConstants.CENTER));
        add(new JLabel(String.valueOf(player.getWins()), SwingConstants.CENTER));

        add(new JLabel("Losses (+0 pts):", SwingConstants.CENTER));
        add(new JLabel(String.valueOf(player.getLosses()), SwingConstants.CENTER));

        add(new JLabel("Draws (+3 pts):", SwingConstants.CENTER));
        add(new JLabel(String.valueOf(player.getDraws()), SwingConstants.CENTER));

        add(new JLabel("Total Score:", SwingConstants.CENTER));
        add(new JLabel(String.valueOf(player.getScore()), SwingConstants.CENTER));
    }


}
