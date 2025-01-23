import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Travel extends JFrame implements ActionListener{

    JButton computeButton, payButton;
    JCheckBox shakeBox, fewaBox, gulamanBox, hotcakeBox, tofuBox, siomaiBox, friedNoodleBox, chickenBox;
    JRadioButton pwdButton, seniorButton;
    JTextField totalText, moneyText, changeText, vatText;

    Travel() {
        super("Travel");
        setLayout(null);
        setSize(350, 550);

        // Title Label
        JLabel titleLabel = new JLabel("PUP Lagoon");
        titleLabel.setBounds(115, 10, 300, 30);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        add(titleLabel);

        // Panel
        JPanel namePanel = new JPanel(new GridLayout(1, 2));
        JPanel coursePanel = new JPanel(new GridLayout(1, 2));
        JPanel checkboxPanel = new JPanel(new GridLayout(4, 2));
        JPanel discountPanel = new JPanel(new GridLayout(1, 3));
        JPanel paymentPanel = new JPanel(new GridLayout(4, 2));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        // Name Label
        JLabel nameLabel = new JLabel("Name  :");
        nameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        namePanel.add(nameLabel);

        // Name Text Field
        JTextField nameText = new JTextField();
        nameText.setFont(new Font("Dialog", Font.BOLD, 15));
        nameText.setPreferredSize(new Dimension(250, 30)); // Set preferred size 
        namePanel.add(nameText);

        // Course Label
        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        coursePanel.add(courseLabel);

        // Course Text Field
        JTextField courseText = new JTextField();
        courseText.setFont(new Font("Dialog", Font.BOLD, 15));
        courseText.setPreferredSize(new Dimension(250, 30)); // Set preferred size
        coursePanel.add(courseText);

        // Items Label
        JLabel itemsLabel = new JLabel("Items");
        itemsLabel.setFont(new Font("Dialog", Font.BOLD, 15));

        // Checkbox
        shakeBox = new JCheckBox("Shake");
        shakeBox.setFocusable(false);
        shakeBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(shakeBox);

        fewaBox = new JCheckBox("Fewa");
        fewaBox.setFocusable(false);
        fewaBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(fewaBox);

        gulamanBox = new JCheckBox("Gulaman");
        gulamanBox.setFocusable(false);
        gulamanBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(gulamanBox);

        hotcakeBox = new JCheckBox("Hotcake");
        hotcakeBox.setFocusable(false);
        hotcakeBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(hotcakeBox);

        tofuBox = new JCheckBox("Tofu");
        tofuBox.setFocusable(false);
        tofuBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(tofuBox);

        siomaiBox = new JCheckBox("Siomai w/ Rice");
        siomaiBox.setFocusable(false);
        siomaiBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(siomaiBox);

        friedNoodleBox = new JCheckBox("Fried Noodle");
        friedNoodleBox.setFocusable(false);
        friedNoodleBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(friedNoodleBox);

        chickenBox = new JCheckBox("Chicken w/ Rice");
        chickenBox.setFocusable(false);
        chickenBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        checkboxPanel.add(chickenBox);

        // Discount Label
        JLabel discountLabel = new JLabel("Discount:");
        discountLabel.setFont(new Font("Dialog", Font.BOLD, 15));

        // Discount Radio
        pwdButton = new JRadioButton("PWD");
        seniorButton = new JRadioButton("Senior");
        JRadioButton noButton = new JRadioButton("No Discount");

        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(pwdButton);
        discountGroup.add(seniorButton);
        discountGroup.add(noButton);

        discountPanel.add(pwdButton);
        discountPanel.add(seniorButton);
        discountPanel.add(noButton);

        // Payment Label
        JLabel paymentLabel = new JLabel("Payment Details:");
        paymentLabel.setFont(new Font("Dialog", Font.BOLD, 15));

        // Payment Text Field
        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(totalLabel);

        totalText = new JTextField();
        totalText.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(totalText);

        JLabel moneyLabel = new JLabel("Money:");
        moneyLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(moneyLabel);

        moneyText = new JTextField();
        moneyText.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(moneyText);

        JLabel changeLabel = new JLabel("Change: ");
        changeLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(changeLabel);

        changeText = new JTextField();
        changeText.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(changeText);

        JLabel vatLabel = new JLabel("VAT:");
        vatLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(vatLabel);

        vatText = new JTextField();
        vatText.setFont(new Font("Dialog", Font.PLAIN, 15));
        paymentPanel.add(vatText);

        // Button 
        computeButton = new JButton("Compute");
        computeButton.setFocusable(false);
        computeButton.addActionListener(this);
        buttonPanel.add(computeButton);

        payButton = new JButton("Pay");
        payButton.setFocusable(false);
        payButton.addActionListener(this);
        buttonPanel.add(payButton);

        // Set Bounds
        namePanel.setBounds(5, 50, 330, 30);
        coursePanel.setBounds(5, 90, 330, 30);
        itemsLabel.setBounds(5, 130, 330, 40);
        checkboxPanel.setBounds(5, 160, 330, 100);
        discountLabel.setBounds(5, 250, 300, 30);
        discountPanel.setBounds(5, 280, 330, 20);
        paymentLabel.setBounds(5, 300, 330, 30);
        paymentPanel.setBounds(5, 330, 330, 100);
        buttonPanel.setBounds(5, 440, 320, 30);

        // Name Panel Add
        add(namePanel);
        add(coursePanel);
        add(itemsLabel);
        add(checkboxPanel);
        add(discountLabel);
        add(discountPanel);
        add(paymentLabel);
        add(paymentPanel);
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    // Shake - 50
    // Fewa - 50
    // Gulaman - 30
    // Hotcake - 40
    // Tofu - 50
    // Siomai - 20
    // Fried Noodle - 50
    // Chicken - 100

    @Override
    public void actionPerformed(ActionEvent e) {
        float total = 0;

        if(e.getSource()==computeButton){
            if (shakeBox.isSelected()) total += 50;
            if (fewaBox.isSelected()) total += 50;
            if (gulamanBox.isSelected()) total += 30;
            if (hotcakeBox.isSelected()) total += 40;
            if (tofuBox.isSelected()) total += 50;
            if (siomaiBox.isSelected()) total += 20;
            if (friedNoodleBox.isSelected()) total += 50;
            if (chickenBox.isSelected()) total += 100;
            if (pwdButton.isSelected() || seniorButton.isSelected()) total *= 0.8;

            if(total >= 0){
                totalText.setText(String.valueOf(total));
                vatText.setText(String.valueOf(total + (total * 0.12)));
            }
        }

        if (e.getSource()==payButton){
            String total1 = totalText.getText();
            total = Float.parseFloat(total1);

            String money1 = moneyText.getText();
            float money = Float.parseFloat(money1);
            float change = money - total;
            System.out.print(total);
            if (totalText.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Choose first from the Menu", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (change < 0){
                    JOptionPane.showMessageDialog(null, "Insuffiecient amount money", "Error", JOptionPane.ERROR_MESSAGE);
                }
                changeText.setText(String.valueOf(change));
            }
        }
    }
    
    public static void main(String[] args) {
        new Travel();
    }
}
