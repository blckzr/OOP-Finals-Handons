
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class TravelGui extends JFrame implements ActionListener{
    
    JRadioButton oneWayButton, roundTripButton, domesticButton, internationalButton, discountButton;

    JComboBox fromComboBox, toComboBox;
    String[] areas = {"Manila", "USA", "Japan", "South Korea", "China"};

    JCheckBox baggage20Box, baggage32Box, mealBox, seatBox;
    
    JTextField voucherText;

    TravelGui (){
        super("Travel");
        setLayout(null);
        setSize(400, 600);

        // Title Label
        JLabel titleLabel = new JLabel("ABC Travels");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 15));

        // Panel Declarion
        JPanel modePanel = new JPanel(new GridLayout(2, 2));
        JPanel travelPanel = new JPanel(new GridLayout(2, 2));
        JPanel addPanel = new JPanel(new GridLayout(2, 2));
        JPanel discountPanel = new JPanel(new GridLayout(2, 2));

        // Mode Selection
        oneWayButton = new JRadioButton("One Way");
        roundTripButton = new JRadioButton("Round Trip");
        domesticButton = new JRadioButton("Domestic");
        internationalButton = new JRadioButton("International");


        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(oneWayButton);
        modeGroup.add(roundTripButton);
        modeGroup.add(domesticButton);
        modeGroup.add(internationalButton);

        modePanel.add(oneWayButton);
        modePanel.add(roundTripButton);
        modePanel.add(domesticButton);
        modePanel.add(internationalButton);

        // Departure Panel
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        travelPanel.add(fromLabel);

        JLabel toLabel = new JLabel("To:");
        toLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        travelPanel.add(toLabel);

        fromComboBox = new JComboBox(areas);
        fromComboBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        travelPanel.add(fromComboBox);

        toComboBox = new JComboBox(areas);
        toComboBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        travelPanel.add(toComboBox);

        // Add-ons Panel
        JLabel addLabel = new JLabel("Add Ons");
        addLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        baggage20Box = new JCheckBox("Addtional 20kg Baggage");
        addPanel.add(baggage20Box);
        mealBox = new JCheckBox("Meal");
        addPanel.add(mealBox);
        baggage32Box = new JCheckBox("Addtional 32kg Baggage");
        addPanel.add(baggage32Box);
        seatBox = new JCheckBox("Choose a seat");
        addPanel.add(seatBox);

        // Discount and Voucher
        JLabel discountLabel = new JLabel("Discount");
        discountLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        discountPanel.add(discountLabel);

        JLabel voucherLabel = new JLabel("Voucher");
        voucherLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        discountPanel.add(voucherLabel);
        
        discountButton = new JRadioButton("PWD/Senior");
        discountButton.setFont(new Font("Dialog", Font.PLAIN, 15));
        discountPanel.add(discountButton);

        voucherText = new JTextField();
        voucherText.setFont(new Font("Dialog", Font.PLAIN, 15));
        discountPanel.add(voucherText);

        // Set bounds
        titleLabel.setBounds(150, 10, 340, 20);
        modePanel.setBounds(5, 35, 370, 50);
        travelPanel.setBounds(5, 90, 370, 40);
        addLabel.setBounds(5, 135, 370, 20);
        addPanel.setBounds(5, 160, 370, 40);
        discountLabel.setBounds(5, 205, 370, 20);
        discountPanel.setBounds(5, 230, 370, 45);

        // Add Component
        add(titleLabel);
        add(modePanel);
        add(travelPanel);
        add(addLabel);
        add(addPanel);
        add(discountPanel);

        // Last Interaction
        setVisible(true);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String[] args){
        new TravelGui();
    }
}
