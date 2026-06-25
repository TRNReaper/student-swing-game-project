import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TopScorersFrame extends JFrame {
    private JTable table;
    private PlayerService playerService;

    public TopScorersFrame() {
        setTitle("Top 5 Scorers");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        playerService = new PlayerService();
        String[] columns = {"Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        // Fetch Top 5 from the database using service
        ArrayList<Player> topPlayers = playerService.getTopFives();
        for (Player p : topPlayers) {
            model.addRow(new Object[]{
                    p.getUsername(),
                    p.getWins(),
                    p.getLosses(),
                    p.getDraws(),
                    p.getScore()
            });
        }

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }


}
