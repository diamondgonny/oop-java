package academy.pocu.comp2500.lab11;


import academy.pocu.comp2500.lab11.pocu.Department;
import academy.pocu.comp2500.lab11.pocu.PermanentlyClosedException;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class App {
    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        User user = new User();
        SafeWallet wallet;
        Product product;
        Warehouse warehouse = chooseWarehouse(in, out, err);

        if (warehouse == null) {
            return;
        }

        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return;
        }

        while (true) {
            product = chooseProduct(in, out, err, warehouse, wallet);

            if (product == null) {
                return;
            }

            try {
                validatePurchase(warehouse, wallet, product);
            } catch (ProductNotFoundException e) {
                err.println(e.toString());
                e.printStackTrace();
                continue;
            } catch (IllegalAccessException e) {
                err.println(e.toString());
                continue;
            } catch (Exception e) {
                err.println(e.toString());
                continue;
            }

            warehouse.removeProduct(product.getId());
            out.println("successfully purchased!");
        }
    }

    private void validatePurchase(Warehouse warehouse, Wallet wallet, Product product)
            throws ProductNotFoundException, IllegalAccessException {
        boolean productExists = false;
        for (Product targetProduct : warehouse.getProducts()) {
            if (targetProduct.getId().equals(product.getId())) {
                productExists = true;
            }
        }
        if (!productExists) {
            throw new ProductNotFoundException(product.toString());
        }
        if (!wallet.withdraw(product.getPrice())) {
            throw new IllegalAccessException("no money, work harder!!!");
        }
    }

    private Product chooseProduct(BufferedReader in, PrintStream out, PrintStream err,
                                  Warehouse warehouse, Wallet wallet) {
        int selectedNum;
        Product selectedProduct;
        String input4 = null;

        while (true) {
            int amount = wallet.getAmount();
            out.println(String.format("BALANCE: <%d>", amount));
            out.println("PRODUCT_LIST: Choose the product you want to buy!");
            for (int i = 0; i < warehouse.getProducts().size(); i++) {
                Product product = warehouse.getProducts().get(i);
                out.println(String.format("%d. %-20s %d", i + 1, product.getName(), product.getPrice()));
            }

            try {
                input4 = in.readLine();
            } catch (IOException e) {
                err.println(e.toString());
            }
            if (input4.equals("exit")) {
                return null;
            }

            try {
                selectedNum = Integer.parseInt(input4);
                selectedProduct = warehouse.getProducts().get(selectedNum - 1);
            } catch (NumberFormatException e) {
                err.println(e.toString());
                continue;
            } catch (IndexOutOfBoundsException e) {
                err.println(e.toString());
                continue;
            } catch (PermanentlyClosedException e) {
                err.println(e.toString());
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
        return selectedProduct;
    }

    private Warehouse chooseWarehouse(BufferedReader in, PrintStream out, PrintStream err) {
        int selectedNum;
        Warehouse selectedWarehouse;
        String input1 = null;

        while (true) {
            out.println("WAREHOUSE: Choose your warehouse!");
            WarehouseType[] types = WarehouseType.values();
            for (int i = 0; i < types.length; i++) {
                out.println(String.format("%d. %s", i + 1, types[i].toString()));
            }

            try {
                input1 = in.readLine();
                if (input1.equals("exit")) {
                    return null;
                }
                selectedNum = Integer.parseInt(input1);
            } catch (Exception e) {
                err.println(e.toString());
                continue;
            }

            if (1 <= selectedNum && selectedNum <= types.length) {
                selectedWarehouse = new Warehouse(types[selectedNum - 1]);
                break;
            }
/*
            try {
                selectedWarehouse = new Warehouse(types[selectedNum - 1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                err.println(e.toString());
                continue;
            } catch (PermanentlyClosedException e) {
                err.println(e.toString());
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            break;
*/
        }
        return selectedWarehouse;
    }
}
