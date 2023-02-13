package shopdata.data_source.cart;

import shopdata.models.CartItem;
import shopdata.models.Product;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource {

    private ArrayList<CartItem> cart = new ArrayList<>();

    @Override
    public void addToCart(Product product, int count) {
        cart.add(new CartItem(product, count));

    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }
}
