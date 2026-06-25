import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private Player currentPlayer;
    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorers;
    private JButton btnExit;

    public MainMenuFrame(Player player) {
        this.currentPlayer = player;

        // GUI Layout
        setTitle("Main Menu - Welcome " + player.getUsername());
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 15, 15));

        btnStartGame = new JButton("Start Game");
        btnStatistics = new JButton("View My Statistics");
        btnTopScorers = new JButton("View Top 5 Scorers");
        btnExit = new JButton("Exit");

        add(btnStartGame);
        add(btnStatistics);
        add(btnTopScorers);
        add(btnExit);

        // Event Handling
        btnStartGame.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(currentPlayer);
            gameFrame.setVisible(true);
            this.dispose();
        });

        btnStatistics.addActionListener(e -> {
            StatisticsFrame statisticsFrame = new StatisticsFrame(currentPlayer);
            statisticsFrame.setVisible(true);
        });

        btnTopScorers.addActionListener(e -> {
            TopScorersFrame topFrame = new TopScorersFrame();
            topFrame.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });
    }


}
