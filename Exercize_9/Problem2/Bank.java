package Exercize_9.Problem2;

public class Bank {
	private TransferListener listener;
	
	public Bank(int num_accounts, int init_balance) {
		accounts_ = new int[num_accounts];
		num_accounts_ = num_accounts;
		for (int i = 0; i < accounts_.length; i++) {
			accounts_[i] = init_balance;
		}
	}
	
	public void setListener(TransferListener listener) {
		this.listener = listener;
	}

	synchronized void transfer(int from, int to, int amount) {
		try {
			System.out.println("from: " + from + " to: " + to + 
				" amount: " + amount);

			if (accounts_[from] < amount) return;
			accounts_[from] = accounts_[from] - amount;
			Thread.sleep((int)(100*Math.random()));
			accounts_[to] = accounts_[to] + amount;
			
			int total = totalBalance();
			System.out.println("Total balance: " + total);
			
			if (listener != null) {
				listener.onTransfer(from, to, amount);
				listener.onBalanceUpdate(total);
			}
		
		} catch (InterruptedException e) {
		
		}
	}

	public synchronized int totalBalance() {
		int total = 0;
		for (int v : accounts_) {
			total = total + v;	
		}
		return total;
	}
	
	public int getNumberAccounts() {
		return num_accounts_;
	}


	private int accounts_[];
	private int num_accounts_;
}
