import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculatorGUI extends JFrame {
    private JTextField[] gradeFields;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JLabel[] subjectLabels;
    private JLabel distinctionLabel;

    public GradeCalculatorGUI() {
        setTitle("Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 10, 10));

        gradeFields = new JTextField[5];
        subjectLabels = new JLabel[5];

        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel("Subject " + (i + 1) + " Grade:");
            gradeFields[i] = new JTextField();
            subjectLabels[i] = new JLabel();
            add(label);
            add(gradeFields[i]);
        }

        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();
        distinctionLabel = new JLabel();

        add(new JLabel()); // Empty cell
        add(calculateButton);

        add(new JLabel()); // Empty cell
        add(resultLabel);

        for (int i = 0; i < 5; i++) {
            add(new JLabel()); // Empty cell
            add(subjectLabels[i]);
        }

        add(new JLabel()); // Empty cell
        add(distinctionLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAverageGrade();
            }
        });
    }

    private void calculateAverageGrade() {
        try {
            double totalGrade = 0;
            boolean failed = false;

            for (int i = 0; i < 5; i++) {
                double grade = Double.parseDouble(gradeFields[i].getText());
                totalGrade += grade;

                if (grade < 50) {
                    failed = true;
                    subjectLabels[i].setText("Failed");
                    subjectLabels[i].setForeground(Color.RED);
                } else {
                    subjectLabels[i].setText("Passed");
                    subjectLabels[i].setForeground(Color.GREEN);
                }
            }

            double averageGrade = totalGrade / 5;

            if (failed) {
                resultLabel.setText("Sorry, you failed with an average grade of " + averageGrade);
            } else {
                resultLabel.setText("Congratulations! You passed with an average grade of " + averageGrade);

                if (averageGrade >= 75) {
                    distinctionLabel.setText("Well done! You achieved a distinction.");
                    distinctionLabel.setForeground(Color.BLUE);
                } else {
                    distinctionLabel.setText("");
                }
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numeric grades for all subjects.");
            distinctionLabel.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GradeCalculatorGUI calculator = new GradeCalculatorGUI();
                calculator.setSize(400, 300);
                calculator.setVisible(true);
            }
        });
    }
}