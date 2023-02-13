package shopdata.view;

import shopdata.common.AppView;
import shopdata.models.CartItem;
import shopdata.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    final ShopService shopService;

    public CartView(ShopService shopService) {

        super("Корзина", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.product.id + " " + cartItem.product.title + " " + cartItem.count);
        }
        System.out.println();
    }
}
