package Exercize_9.Problem2;

// "Transfer" threads select a random amount of money in [0, max_amount]
// and transfer it to a random account in the bank.

public class Transfer extends Thread{
	public Transfer(Bank bank, int from, int max_amount, Object [] locks) {
        locks__ = locks;
		bank_ = bank;
		from_ = from;
		max_ = max_amount;
        locks__ = locks;
	}

	public void run() {
        while (true) {
		    int to = (int) (Math.random() * bank_.getNumberAccounts());
		    int amount = (int) (Math.random() * max_);
		    int first = Math.min(from_, to);
		    int second = Math.max(from_, to);
            synchronized (locks__[first]) {
                synchronized (locks__[second]) {
		            bank_.transfer(from_, to, amount);
                }
            }
        }
	}

	private Bank bank_;
	private int from_;
	private int max_;
    private Object [] locks__ ;
}
