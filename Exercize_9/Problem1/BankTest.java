package Exercize_9.Problem1;

public class BankTest {
	public static final int N_ACCOUNTS = 5;
	public static final int INIT_BALANCE = 1000;


	public static void main(String args[]) {
	
		Bank bank = new Bank(N_ACCOUNTS, INIT_BALANCE);
        Object[] locks = new Object[N_ACCOUNTS];
        for (int i = 0; i < N_ACCOUNTS; i++) {
            locks[i] = new Object();
        }
        for (int i = 0; i < N_ACCOUNTS; i++) {
            Transfer t = new Transfer(bank, i, INIT_BALANCE, locks);
            t.start();
        }
		
	}
}
