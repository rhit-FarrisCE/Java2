package Exercize_9.Problem2;

/**
 * Listener interface for transfer events
 */
public interface TransferListener {
    void onTransfer(int from, int to, int amount);
    void onBalanceUpdate(int totalBalance);
}
