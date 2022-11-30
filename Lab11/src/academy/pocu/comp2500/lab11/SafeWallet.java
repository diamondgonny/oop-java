package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(final User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(final int amount) {
        if (amount > 0 && this.getAmount() + amount <= 0) {
            throw new OverflowException("wallet exceeded the limit, are you bin salman?");
        }
        return super.deposit(amount);
    }
}
