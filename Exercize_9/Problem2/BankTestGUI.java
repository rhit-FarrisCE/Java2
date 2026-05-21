package Exercize_9.Problem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankTestGUI implements TransferListener {
	public static final int N_ACCOUNTS = 5;
	public static final int INIT_BALANCE = 1000;
	
	private Bank bank;
	private BankManagerWindow managerWindow;
	private TransferWindow[] transferWindows;

	public BankTestGUI() {
		bank = new Bank(N_ACCOUNTS, INIT_BALANCE);
		bank.setListener(this);
		
		// Create bank manager window
		managerWindow = new BankManagerWindow(this);
		managerWindow.setVisible(true);
		
		// Create locks for transfer threads
		Object[] locks = new Object[N_ACCOUNTS];
		for (int i = 0; i < N_ACCOUNTS; i++) {
			locks[i] = new Object();
		}
		
		// Create transfer windows and threads
		transferWindows = new TransferWindow[N_ACCOUNTS];
		for (int i = 0; i < N_ACCOUNTS; i++) {
			transferWindows[i] = new TransferWindow(i);
			transferWindows[i].setVisible(true);
			Transfer t = new Transfer(bank, i, INIT_BALANCE, locks);
			t.start();
		}
		
		// Update initial balance in manager
		SwingUtilities.invokeLater(() -> {
			managerWindow.updateBalance(bank.totalBalance());
		});
	}
	
	@Override
	public void onTransfer(int from, int to, int amount) {
		SwingUtilities.invokeLater(() -> {
			transferWindows[from].addTransferRecord(from, to, amount);
		});
	}
	
	@Override
	public void onBalanceUpdate(int totalBalance) {
		SwingUtilities.invokeLater(() -> {
			managerWindow.updateBalance(totalBalance);
		});
	}
	
	public void exitProgram() {
		// Close all transfer windows
		for (int i = 0; i < transferWindows.length; i++) {
			transferWindows[i].dispose();
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new BankTestGUI();
		});
	}
}

/**
 * Bank manager window showing overall balance status
 */
class BankManagerWindow extends JFrame {
	private JLabel balanceLabel;
	private BankTestGUI gui;
	
	public BankManagerWindow(BankTestGUI gui) {
		this.gui = gui;
		setTitle("Bank Manager - Overall Status");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Add window closing listener
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gui.exitProgram();
			}
		});
		
		// Create GUI components
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JLabel titleLabel = new JLabel("Total Bank Balance");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(titleLabel);
		
		panel.add(Box.createVerticalStrut(10));
		
		balanceLabel = new JLabel("Balance: $" + 0);
		balanceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(balanceLabel);
		
		panel.add(Box.createVerticalStrut(20));
		
		JLabel instructionLabel = new JLabel("Close this window to exit the program");
		instructionLabel.setFont(new Font("Arial", Font.ITALIC, 12));
		panel.add(instructionLabel);
		
		add(panel);
	}
	
	public void updateBalance(int balance) {
		balanceLabel.setText("Balance: $" + balance);
	}
}

/**
 * Individual transfer window for each account
 */
class TransferWindow extends JFrame {
	private JTextArea transferLog;
	private int accountNumber;
	
	public TransferWindow(int accountNumber) {
		this.accountNumber = accountNumber;
		setTitle("Account " + accountNumber + " - Transfer Activity");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Create GUI components
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Header
		JLabel titleLabel = new JLabel("Account #" + accountNumber + " - Transfer Log");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(titleLabel, BorderLayout.NORTH);
		
		// Transfer log area
		transferLog = new JTextArea();
		transferLog.setEditable(false);
		transferLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
		transferLog.setText("Waiting for transfers...\n");
		
		JScrollPane scrollPane = new JScrollPane(transferLog);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		add(panel);
	}
	
	public void addTransferRecord(int from, int to, int amount) {
		if (from == accountNumber) {
			String record = String.format("[%s] Sent $%d to Account %d\n", 
				formatTime(), amount, to);
			transferLog.append(record);
			transferLog.setCaretPosition(transferLog.getDocument().getLength());
		}
	}
	
	private String formatTime() {
		return String.format("%02d:%02d:%02d", 
			System.currentTimeMillis() / 3600000 % 24,
			System.currentTimeMillis() / 60000 % 60,
			System.currentTimeMillis() / 1000 % 60);
	}
}
