import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeInMotion {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Life In Motion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel stepsLabel = new JLabel("Enter daily steps:");
        JTextField stepsField = new JTextField();

        JLabel standingLabel = new JLabel("Enter minutes standing:");
        JTextField standingField = new JTextField();

        JButton calculateButton = new JButton("Calculate Smart Score");

        JLabel resultLabel = new JLabel("Smart Score: ");
        JLabel discountLabel = new JLabel("Discount: ");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int steps = Integer.parseInt(stepsField.getText());
                    int standingMinutes = Integer.parseInt(standingField.getText());

                    int smartScore = 0;
                    int stepScore = 0;
                    int standScore = 0;
                    int discount = 0;

                    if (steps <= 5_000) {
                        stepScore = 0;
                    } else if (steps <= 7_000) {
                        stepScore = 1;
                    } else if (steps <= 10_000) {
                        stepScore = 2;
                    } else if (steps <= 15_000) {
                        stepScore = 3;
                    } else if (steps <= 20_000) {
                        stepScore = 4;
                    } else if (steps >= 20_000) {
                        stepScore = 5;
                    }

                    if (standingMinutes <= 30) {
                        standScore = 0;
                    } else if (standingMinutes <= 60) {
                        standScore = 1;
                    } else if (standingMinutes <= 90) {
                        standScore = 2;
                    } else if (standingMinutes <= 120) {
                        standScore = 3;
                    } else if (standingMinutes <= 150) {
                        standScore = 4;
                    } else if (standingMinutes >= 180) {
                        standScore = 5;
                    }

                    smartScore = (stepScore + standScore) / 2;
                    discount = smartScore * 5;

                    resultLabel.setText("Smart Score: " + smartScore);
                    discountLabel.setText("Discount: " + discount + '%');
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        stepsLabel.setForeground(new Color(200, 0, 0));
        standingLabel.setForeground(new Color(200, 0, 0));
        resultLabel.setForeground(new Color(0, 0, 0));
        discountLabel.setForeground(new Color(0, 0, 0));
        calculateButton.setBackground(new Color(220, 0, 0));
        calculateButton.setForeground(Color.WHITE);
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        frame.add(stepsLabel);
        frame.add(stepsField);
        frame.add(standingLabel);
        frame.add(standingField);
        frame.add(calculateButton);
        frame.add(resultLabel);
        frame.add(discountLabel);

        frame.setVisible(true);
    }
}
