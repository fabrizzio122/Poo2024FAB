import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends JFrame {
    private JTextField player1Field;
    private JTextField player2Field;
    private JButton startButton;
    private JButton cancelButton;
    private JTable resultsTable;
    private DefaultTableModel tableModel;
    private Game game;
    private Database database;

    public Main() {
        setTitle("Tic Tac Toe");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        database = new Database("game_results.db");

        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        topPanel.add(new JLabel("Nombre Jugador 1:"));
        player1Field = new JTextField();
        topPanel.add(player1Field);
        topPanel.add(new JLabel("Nombre Jugador 2:"));
        player2Field = new JTextField();
        topPanel.add(player2Field);

        startButton = new JButton("Iniciar");
        cancelButton = new JButton("Anular");
        topPanel.add(startButton);
        topPanel.add(cancelButton);

        add(topPanel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        JButton[][] buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                final int row = i;
                final int col = j;
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(e -> {
                    if (game != null && game.makeMove(row, col)) {
                        buttons[row][col].setText(game.getCurrentPlayer().equals(game.getPlayer1()) ? "X" : "O");
                        if (game.getCurrentPlayer().equals(game.getPlayer1())) {
                            buttons[row][col].setForeground(Color.RED);
                        } else {
                            buttons[row][col].setForeground(Color.BLUE);
                        }
                        if (game.getWinner() != null) {
                            JOptionPane.showMessageDialog(this, "Winner: " + game.getWinner());
                            updateResultsTable();
                            game = null;
                        }
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new Object[]{"Player 1", "Player 2", "Winner", "Score", "Status"}, 0);
        resultsTable = new JTable(tableModel);
        add(new JScrollPane(resultsTable), BorderLayout.EAST);

        startButton.addActionListener(e -> startGame());
        cancelButton.addActionListener(e -> cancelGame());

        setVisible(true);
    }

    private void startGame() {
        String player1 = player1Field.getText();
        String player2 = player2Field.getText();
        if (!player1.isEmpty() && !player2.isEmpty()) {
            game = new Game(player1, player2, database);
        }
    }

    private void cancelGame() {
        game = null;
    }

    private void updateResultsTable() {
        tableModel.setRowCount(0);
        ResultSet rs = database.getAllGameResults();
        try {
            while (rs.next()) {
                String player1 = rs.getString("player1");
                String player2 = rs.getString("player2");
                String winner = rs.getString("winner");
                String score = rs.getString("score");
                String status = rs.getString("status");
                tableModel.addRow(new Object[]{player1, player2, winner, score, status});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
