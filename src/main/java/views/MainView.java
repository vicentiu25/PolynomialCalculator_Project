package views;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class MainView extends JFrame {

    private JTextField firstTextField;
    private JTextField secondTextField;
    private JTextField resultTextField;
    private JTextField remainderTextField;

    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplicateButton;
    private JButton divideButton;
    private JButton derivateButton;
    private JButton integrateButton;

    public MainView() {
        this.setBounds(100, 100, 750, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel mainPanel = new JPanel();
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel titlePanel = new JPanel();
        mainPanel.add(titlePanel);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        titlePanel.add(titleLabel);

        JPanel outputPanel = new JPanel();
        mainPanel.add(outputPanel);
        outputPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel firstLabel = new JLabel("First Polynomial =");
        firstLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        outputPanel.add(firstLabel);

        firstTextField = new JTextField();
        firstTextField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        outputPanel.add(firstTextField);

        JLabel secondLabel = new JLabel("Second Polynomial =");
        secondLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        outputPanel.add(secondLabel);

        secondTextField = new JTextField();
        secondTextField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        outputPanel.add(secondTextField);

        JLabel resultLabel = new JLabel("Result =");
        resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        outputPanel.add(resultLabel);

        resultTextField = new JTextField();
        resultTextField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        outputPanel.add(resultTextField);

        JLabel remainderLabel = new JLabel("Remainder =");
        remainderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        outputPanel.add(remainderLabel);

        remainderTextField = new JTextField();
        remainderTextField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        outputPanel.add(remainderTextField);

        JPanel operationPanel = new JPanel();
        mainPanel.add(operationPanel);
        operationPanel.setLayout(new GridLayout(0, 2, 0, 0));

        addButton = new JButton("Add");
        addButton.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        operationPanel.add(addButton);

        subtractButton = new JButton("Subtract");
        subtractButton.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        operationPanel.add(subtractButton);

        multiplicateButton = new JButton("Multiplicate");
        multiplicateButton.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        operationPanel.add(multiplicateButton);

        divideButton = new JButton("Divide");
        divideButton.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        operationPanel.add(divideButton);

        derivateButton = new JButton("Derivate");
        derivateButton.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        operationPanel.add(derivateButton);

        integrateButton = new JButton("Integrate");
        integrateButton.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        operationPanel.add(integrateButton);

        this.setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplicateButton() {
        return multiplicateButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDerivateButton() {
        return derivateButton;
    }

    public JButton getIntegrateButton() {
        return integrateButton;
    }

    public String getFirstTextField() {
        return firstTextField.getText();
    }

    public String getSecondTextField() {
        return secondTextField.getText();
    }

    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this,message);
    }
    public void setResultTextField(String resultTextField) {
        this.resultTextField.setText(String.valueOf(resultTextField));
    }

    public void setRemainderTextField(String remainderTextField) {
        this.remainderTextField.setText(String.valueOf(remainderTextField));
    }
}
