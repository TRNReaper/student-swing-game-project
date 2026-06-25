import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();

        // GUI Layout Initialization
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        lblStatus = new JLabel("Your turn (X)", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        buttons = new JButton[9];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            boardPanel.add(buttons[i]);
        }
        add(boardPanel, BorderLayout.CENTER);
    }

    private void handlePlayerMove(int index) {
        // Player move logic
        if (gameLogic.makeMove(index, 'X')) {
            buttons[index].setText("X");

            // Check Player Win
            if (gameLogic.checkWinner('X')) {
                finishGame("WIN");
                return;
            }
            // Check Draw
            if (gameLogic.isDraw()) {
                finishGame("DRAW");
                return;
            }

            // Computer move logic
            int compMove = gameLogic.computerMove();
            if (compMove != -1 && gameLogic.makeMove(compMove, 'O')) {
                buttons[compMove].setText("O");

                // Check Computer Win (Player Lose)
                if (gameLogic.checkWinner('O')) {
                    finishGame("LOSE");
                    return;
                }
                // Check Draw after computer moves
                if (gameLogic.isDraw()) {
                    finishGame("DRAW");
                    return;
                }
            }
        }
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        JOptionPane.showMessageDialog(this, "Game result: " + result);
        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }


}
