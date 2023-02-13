package shopdata.models;

// CartItem - Product, count

public class CartItem {

    public final Product product;
    public final int count;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
