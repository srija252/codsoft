import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATMGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JTextField balanceField;
    private JTextField amountField;
    private JTextArea outputArea;

    public ATMGUI(BankAccount account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel balanceLabel = new JLabel("Balance:");
        balanceField = new JTextField(Double.toString(account.getBalance()));
        balanceField.setEditable(false);

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(this);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(new JScrollPane(outputArea));

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Check Balance")) {
            outputArea.setText("Current balance: " + account.getBalance());
        } else if (command.equals("Deposit")) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    account.deposit(amount);
                    balanceField.setText(Double.toString(account.getBalance()));
                    outputArea.setText("Deposit successful.");
                } else {
                    outputArea.setText("Invalid deposit amount.");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input. Please enter a valid amount.");
            }
        } else if (command.equals("Withdraw")) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0 && account.withdraw(amount)) {
                    balanceField.setText(Double.toString(account.getBalance()));
                    outputArea.setText("Withdrawal successful.");
                } else {
                    outputArea.setText("Invalid withdrawal amount or insufficient balance.");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input. Please enter a valid amount.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATMGUI frame = new ATMGUI(account);
        frame.setVisible(true);
    }
}
