package shopdata;

import shopdata.common.AppView;
import shopdata.common.PageLoop;
import shopdata.comporators.AppComparator;
import shopdata.comporators.PriceComparator;
import shopdata.data_source.cart.CartDataSource;
import shopdata.data_source.cart.MockCartDataSourceImpl;
import shopdata.data_source.catalog.CatalogDataSource;
import shopdata.data_source.catalog.MockCatalogDataSourceImpl;
import shopdata.data_source.order.MockOrderDataSourceImpl;
import shopdata.data_source.order.OrderDataSource;
import shopdata.models.Product;
import shopdata.service.ShopService;
import shopdata.view.*;

import java.util.ArrayList;
/*
models:
Product - id, title, description, price, available
CatItem - Product, count
Order - name, phone, address, paymentType, deliveryTime, List<CartItem> cart
Фичи:
- просмотр каталога
    - добавление в корзину по id
        - сколько штук
    - просмотр корзины
    - оформить заказ
        - ввод данных
Какую фиу выбираете?
(1) вариант1
(2) вариант2
(3) вариант3

Ведите данные
свободный ввод
 */

public class ShopOnline {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        ArrayList<AppComparator<Product>> catalogComparators = new ArrayList<>();
        catalogComparators.add(new AppComparator<>(new PriceComparator(true), "по возрастанию цены"));
        catalogComparators.add(new AppComparator<>(new PriceComparator(false), "по убыванию цены"));
        AppView catalogView = new CatalogView(shopService, catalogChildren, catalogComparators);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();

    }
}
