package shopdata.view;

import shopdata.common.AppView;
import shopdata.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    final ShopService shopService;

    public OrderView(ShopService shopService) {

        super("Оформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите свое имя");
        String name = in.nextLine();
        System.out.println("Введите свой телефон");
        String phone = in.nextLine();
        shopService.createOrder(name, phone, "address", "cash", "утро 18-19 часов");
    }
}
