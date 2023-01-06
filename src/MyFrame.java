import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {

    JPanel topPanel = new JPanel(new BorderLayout());
    JLabel topLabel = new JLabel("TicTacToe Game Start");
    JButton resetButton = new JButton("Reset");
    JPanel mainPanel = new JPanel(new GridLayout(3, 3));
    JButton[] buttons = new JButton[9];
    Random random = new Random();
    boolean player1turn;

    MyFrame() {
        // top panel start
        topPanel.setPreferredSize(new Dimension(100, 100));
        topPanel.setBackground(Color.GRAY);
        // top panel end

        // top label start
        topLabel.setFont(new Font("Comic Sans Ms", Font.PLAIN, 40));
        topLabel.setForeground(Color.WHITE);
        topLabel.setVerticalAlignment(SwingConstants.CENTER);
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // top label end

        // reset button start
        resetButton.setFont(new Font("Comic Sans Ms", Font.PLAIN, 40));
        resetButton.setFocusable(false);
        resetButton.setVisible(false);
        resetButton.addActionListener(this);
        // reset button end

        // adding components inside top Panel start
        topPanel.add(topLabel, BorderLayout.CENTER);
        topPanel.add(resetButton, BorderLayout.EAST);
        // adding components inside top Panel end

        // JButtons start
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Comic Sans Ms", Font.BOLD, 60));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(false);
            buttons[i].setBackground(null);
        }
        // JButtons end

        // adding components inside main Panel start
        for (JButton button :
                buttons) {
            mainPanel.add(button);
        }
        // adding components inside main Panel end

        // adding components inside MyFrame start
        this.add(topPanel, BorderLayout.NORTH);
        this.add(mainPanel);
        // adding components inside MyFrame end

        // MyFrame start
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Harsh Tic-Tac-Toe Game");
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // MyFrame end

        firstTurn(); // it will choose the turn
    }

    public void firstTurn() {

        try {
            Thread.sleep(3000);
            for (JButton button : buttons) {
                button.setEnabled(true);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2) == 0) {
            player1turn = true;
            topLabel.setText("X Turn");
        } else {
            player1turn = false;
            topLabel.setText("O Turn");
        }
    }

    public void check() {
        // if x win start
        if ((buttons[0].getText().equals("X")) &&
                (buttons[1].getText().equals("X")) &&
                (buttons[2].getText().equals("X"))) {
            xWin(0, 1, 2);
        } else if ((buttons[3].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[5].getText().equals("X"))) {
            xWin(3, 4, 5);
        } else if ((buttons[6].getText().equals("X")) &&
                (buttons[7].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))) {
            xWin(6, 7, 8);
        } else if ((buttons[0].getText().equals("X")) &&
                (buttons[3].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))) {
            xWin(0, 3, 6);
        } else if ((buttons[1].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[7].getText().equals("X"))) {
            xWin(1, 4, 7);
        } else if ((buttons[2].getText().equals("X")) &&
                (buttons[5].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))) {
            xWin(2, 5, 8);
        } else if ((buttons[0].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))) {
            xWin(0, 4, 8);
        } else if ((buttons[2].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))) {
            xWin(2, 4, 6);
        }
        // if x win end

        // if o win start
        if ((buttons[0].getText().equals("O")) &&
                (buttons[1].getText().equals("O")) &&
                (buttons[2].getText().equals("O"))) {
            oWin(0, 1, 2);
        } else if ((buttons[3].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[5].getText().equals("O"))) {
            oWin(3, 4, 5);
        } else if ((buttons[6].getText().equals("O")) &&
                (buttons[7].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))) {
            oWin(6, 7, 8);
        } else if ((buttons[0].getText().equals("O")) &&
                (buttons[3].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))) {
            oWin(0, 3, 6);
        } else if ((buttons[1].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[7].getText().equals("O"))) {
            oWin(1, 4, 7);
        } else if ((buttons[2].getText().equals("O")) &&
                (buttons[5].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))) {
            oWin(2, 5, 8);
        } else if ((buttons[0].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))) {
            oWin(0, 4, 8);
        } else if ((buttons[2].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))) {
            oWin(2, 4, 6);
        }
        // if o win end
    }

    // method for x win start
    public void xWin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        topLabel.setText("X Win");
    } // method for x win end

    // method for o win start
    public void oWin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        topLabel.setText("O Win");
    } // method for o win end

    @Override
    public void actionPerformed(ActionEvent e) {

        // action for all 9 buttons start
        for (JButton button : buttons) {
            if (e.getSource() == button) {
                if (player1turn) {
                    if (button.getText().equals("")) {
                        button.setForeground(Color.RED);
                        button.setText("X");
                        player1turn = false;
                        topLabel.setText("O Turn");
                        resetButton.setVisible(true);
                        check();
                    }
                } else {
                    if (button.getText().equals("")) {
                        button.setForeground(Color.BLUE);
                        button.setText("O");
                        player1turn = true;
                        topLabel.setText("X Turn");
                        resetButton.setVisible(true);
                        check();
                    }
                }
            }
        }
        // action for all 9 buttons end

        // action for reset button start
        if (e.getSource() == resetButton) {
            for (JButton button :
                    buttons) {
                button.setText("");
                button.setBackground(null);
                button.setEnabled(true);
            }
            if (random.nextInt(2) == 0) {
                player1turn = true;
                topLabel.setText("X Turn");
            } else {
                player1turn = false;
                topLabel.setText("O Turn");
            }
            resetButton.setVisible(false);
        }
        // action for reset button end
    }
}
