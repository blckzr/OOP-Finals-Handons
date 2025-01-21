import java.awt.Font;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Checker extends JFrame implements ActionListener {

    // Instance variables for text fields and result label
    private JTextField palindromeText;
    private JTextField anagramText;
    private JLabel resultLabel;

    // Initialize GUI components
    public void initFrame() {
        JFrame frame = new JFrame("Checker");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Initialize Labels
        JLabel palindromeLabel = new JLabel("Palindrome:");
        JLabel anagramLabel = new JLabel("Anagram:");
        JLabel resultTitleLabel = new JLabel("Result:");
        resultLabel = new JLabel("Use Palindrome as secondary string");

        // Initialize TextField
        palindromeText = new JTextField();
        anagramText = new JTextField();

        // Initialize ButtonsW
        JButton palindromeButton = new JButton("Palindrome");
        JButton anagramButton = new JButton("Anagram");
        JButton clearButton = new JButton("Clear/Reset");

        // Palindrome Label
        palindromeLabel.setBounds(5, 10, 300, 30);
        palindromeLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        palindromeLabel.setHorizontalAlignment(SwingConstants.LEFT);

        // Anagram Label
        anagramLabel.setBounds(5, 85, 300, 30);
        anagramLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        anagramLabel.setHorizontalAlignment(SwingConstants.LEFT);

        // Result Title Label
        resultTitleLabel.setBounds(0, 285, 300, 30);
        resultTitleLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        resultTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Result Label
        resultLabel.setBounds(0, 315, 300, 30);
        resultLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // TextField
        palindromeText.setBounds(5, 45, 270, 40);
        anagramText.setBounds(5, 115, 270, 40);

        // Buttons
        palindromeButton.setBounds(80, 165, 125, 30);
        palindromeButton.setFocusable(false);
        palindromeButton.setHorizontalAlignment(SwingConstants.CENTER);
        anagramButton.setBounds(80, 205, 125, 30);
        anagramButton.setFocusable(false);
        clearButton.setBounds(80, 245, 125, 30);
        clearButton.setFocusable(false);

        // Add ActionListeners to buttons
        palindromeButton.addActionListener(this);
        anagramButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to the frame
        frame.add(palindromeLabel);
        frame.add(palindromeText);
        frame.add(anagramLabel);
        frame.add(anagramText);
        frame.add(palindromeButton);
        frame.add(anagramButton);
        frame.add(clearButton);
        frame.add(resultTitleLabel);
        frame.add(resultLabel);

        frame.setSize(300, 500);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Palindrome".equals(e.getActionCommand())) {
            if (palindromeText.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "The palindrome text field is empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String str = palindromeText.getText().trim();
            if (isPalindrome(str)) {
                resultLabel.setText("Palindrome: Yes");
            } else {
                resultLabel.setText("Palindrome: No");
            }
        } else if ("Anagram".equals(e.getActionCommand())) {
            if (palindromeText.getText().trim().isEmpty() && anagramText.getText().trim().length() > 0) {
                JOptionPane.showMessageDialog(null, "The palindrome text field is empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(anagramText.getText().trim().isEmpty() && palindromeText.getText().trim().length() > 0){
                JOptionPane.showMessageDialog(null, "The anagram text field is empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(anagramText.getText().trim().isEmpty() && palindromeText.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Both text field is empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String str1 = palindromeText.getText().trim();
            String str2 = anagramText.getText().trim();
            if (isAnagram(str1, str2)) {
                resultLabel.setText("Anagram: Yes");
            } else {
                resultLabel.setText("Anagram: No");
            }
        } else if ("Clear/Reset".equals(e.getActionCommand())) {
            palindromeText.setText("");
            anagramText.setText("");
            resultLabel.setText("Use Palindrome as secondary string");
        }
    }

    // Method to clean up strings by removing non-alphabetical characters and converting to lowercase
    public static String cleanString(String text) {
        int size = text.length();
        int cleanIndex = 0;
        char[] clean = new char[size];

        // Store alphabet to array by iterating
        for (int i = 0; i < size; i++) {
            char current = text.charAt(i);
            if ((current >= 'a' && current <= 'z') || (current >= 'A' && current <= 'Z')) {
                clean[cleanIndex++] = current;
            }
        }

        // Return cleaned string (with no trailing spaces)
        return new String(clean, 0, cleanIndex).toLowerCase();
    }

    // Method to reverse a string
    public static String stringReversal(String text) {
        char[] charText = text.toCharArray();
        char[] tempText = new char[charText.length];

        for (int i = 0; i < charText.length; i++) {
            tempText[i] = charText[charText.length - 1 - i];
        }

        return new String(tempText);
    }

    // Palindrome Checker Method
    public static boolean isPalindrome(String text) {
        text = cleanString(text);
        String reversedText = stringReversal(text);
        return text.equals(reversedText);
    }

    // Anagram Checker Method
    public static boolean isAnagram(String str1, String str2) {
        str1 = cleanString(str1);
        str2 = cleanString(str2);

        char[] tempStr1 = str1.toCharArray();
        char[] tempStr2 = str2.toCharArray();

        if (tempStr1.length != tempStr2.length) {
            return false;
        }

        Arrays.sort(tempStr1);
        Arrays.sort(tempStr2);

        return Arrays.equals(tempStr1, tempStr2);
    }

    public static void main(String[] args) {
        Checker checker = new Checker();
        checker.initFrame();
    }
}
