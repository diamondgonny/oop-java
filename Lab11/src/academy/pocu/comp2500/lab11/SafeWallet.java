package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(final int amount) {
        // OverflowException
        // should call super.deposit
        if (!super.deposit(amount)) {
            return false;
        }
        if (this.getAmount() < 0) {
            throw new OverflowException("wallet exceeded the limit, are you bin salman?");
        }
        return true;
    }
}
