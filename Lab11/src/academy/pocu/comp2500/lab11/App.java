package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class App {
    public void run(BufferedReader in, PrintStream out, PrintStream err) {
//        1. 사용자에게 창고(warehouse)를 고르라는 메시지를 보여준다.
//        2. 입력 스트림으로부터 사용자의 선택을 읽어온다.
        Warehouse warehouse = chooseWarehouse(in, out, err);
        if (warehouse == null) {
            return;
        }

//        *3. 사용자 소속 부서의 지갑을 구해온다.
        Wallet wallet = null;
        User user = new User();
        try {
            wallet = new Wallet(user);
        } catch (IllegalAccessException e) {
            // e.printStackTrace();
            err.println("AUTH_ERROR");
            return;
        }

//        4. 지갑의 잔고를 출력한다.
//        5. 사용자에게 구매할 장비를 고르라는 메시지를 보여준다.
//        6. 입력 스트림으로부터 사용자의 선택을 읽어온다.
        // 사용자는 본인이 구매하고자 하는 장비의 번호를 입력해야 합니다. 예를 들어 위 예에서 사용자가 '2'를 입력하면 이는 IPod를 선택했다는 의미입니다.
        // 사용자의 잘못된 입력을 처리하는 것은 여러분의 책임입니다. 잘못된 입력이 들어왔다면 4번 단계로 돌아갑니다.
        // + 만약에 사용자가 선택한 장비의 구매를 완료하기 전에 창고에서 그 장비가 사라졌다면(다른 직원이 같은 시각에 그 장비를 구매할 수 있으니까요~) 더 이상 그 장비를 구매할 수 없겠죠? 이런 경우는 4번 단계로 돌아갑니다.
        Product product;
        while (true) {
            product = chooseProduct(in, out, err, warehouse, wallet);
            if (product == null) {
                return;
            }
            try {
                validatePurchase(out, wallet, product);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
//        7. 6번 단계에서 사용자가 선택한 장비를 구매한 뒤, 4번 단계로 돌아갑니다.
        //C14_RepromptProdListOnNotEnoughBalance
        //지갑에 잔고가 충분하지 못할 때 장비 구매가 실패하는지 검사합니다.
        //
        //C15_RepromptProdListOnProductNotFound
        //구매완료 전에 장비가 사라지는 경우, 동작이 올바른지 검사합니다.
        //
        // C13_RepromptProdListAfterSuccessfulPurchase
        //성공적으로 장비를 구매한 뒤에 앱이 다시 사용자에게 장비를 고르라는 메시지를 보여주는지 검사합니다.
        //또한 지갑의 잔고가 올바른지도 검사합니다.
        //
    }

    private void validatePurchase(PrintStream out, Wallet wallet, Product product)
            throws IllegalAccessException {
        if (!wallet.withdraw(product.getPrice())) {
            throw new IllegalAccessException("no money, work harder!!!");
        } else {
            out.println("successfully purchased!");
        }
    }

    private Product chooseProduct(BufferedReader in, PrintStream out, PrintStream err,
                                  Warehouse warehouse, Wallet wallet) {
        int selectedNum;
        Product selectedProduct;
        String input4 = null;

        while(true) {
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

        while(true) {
            out.println("WAREHOUSE: Choose your warehouse!");
            WarehouseType[] types = WarehouseType.values();
            for (int i = 0; i < types.length; i++) {
                out.println(String.format("%d. %s", i + 1, types[i].toString()));
            }

            try {
                input1 = in.readLine();
            } catch (IOException e) {
                err.println(e.toString());
            }
            if (input1.equals("exit")) {
                return null;
            }

            try {
                selectedNum = Integer.parseInt(input1);
                selectedWarehouse = new Warehouse(types[selectedNum - 1]);
            } catch (NumberFormatException e) {
                err.println(e.toString());
                continue;
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
        }
        return selectedWarehouse;
    }
}
