package shopdata.data_source.cart;

// Фмчи:
// -просмотр каталога.
// -добавление в корзину по id
// -сколько штук
// -просомтр корзины
// -оформить заказ
// -ввод данных

import shopdata.models.CartItem;
import shopdata.models.Product;

import java.util.ArrayList;

public abstract class CartDataSource {


    public abstract void addToCart(Product product, int count);
    public abstract ArrayList<CartItem> getCart();

    public Product productById(String productId) {
        return null;
    }
}
