package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;
import java.io.BufferedReader;
import java.io.PrintStream;

public class App {
    private User user;
    private SafeWallet wallet;
    private Warehouse warehouse;
    private Product product;

    public App() {
        this.user = new User();
    }

    public void run(final BufferedReader in, final PrintStream out, final PrintStream err) {
        while (true) {
            int selectedNum;
            WarehouseType[] types = WarehouseType.values();

            out.println("WAREHOUSE: Choose your warehouse!");
            for (int i = 0; i < types.length; i++) {
                out.printf("%d. %s%s", i + 1, types[i].toString(), System.lineSeparator());
            }

            try {
                String input1 = in.readLine();
                if (input1.equals("exit")) {
                    return;
                }
                selectedNum = Integer.parseInt(input1);
            } catch (Exception e) {
                continue;
            }

            try {
                warehouse = new Warehouse(types[selectedNum - 1]);
                break;
            } catch (IndexOutOfBoundsException ignored) {
                // PermanentlyClosedException should be crashed
            }
        }

        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return;
        }

        while (true) {
            int selectedNum;

            out.printf("BALANCE: %d%s", wallet.getAmount(), System.lineSeparator());
            out.println("PRODUCT_LIST: Choose the product you want to buy!");
            for (int i = 0; i < warehouse.getProducts().size(); i++) {
                product = warehouse.getProducts().get(i);
                out.printf("%d. %-20s %d%n", i + 1, product.getName(), product.getPrice());
            }

            try {
                String input4 = in.readLine();
                if (input4.equals("exit")) {
                    return;
                }
                selectedNum = Integer.parseInt(input4);
            } catch (Exception e) {
                continue;
            }

            try {
                product = warehouse.getProducts().get(selectedNum - 1);
            } catch (IndexOutOfBoundsException e) {
                continue;
            }

            if (!wallet.withdraw(product.getPrice())) {
                continue;
            }

            try {
                warehouse.removeProduct(product.getId());
            } catch (ProductNotFoundException e) {
                wallet.deposit(product.getPrice());
            }
        }
    }
}
