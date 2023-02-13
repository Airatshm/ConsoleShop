package shopdata.view;

import shopdata.common.AppView;
import shopdata.common.Paginable;
import shopdata.comporators.AppComparator;
import shopdata.comporators.PriceComparator;
import shopdata.models.Product;
import shopdata.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView implements Paginable {
    final ShopService shopService;

    public CatalogView(ShopService shopService, ArrayList<AppView> children, ArrayList<AppComparator<Product>> comparators) {

        super("Каталог", children);
        this.shopService = shopService;
        availableComparators.addAll(comparators);
        if (!availableComparators.isEmpty()) {
            selectedComparator = availableComparators.get(0);
        }
    }

    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsk = false;
        ArrayList<Product> catalog = shopService.getCatalog(nowPage, pageLimit, selectedComparator.comparator);
        hasNextPage = catalog.size() == pageLimit;
        for (Product product : catalog) {
            System.out.println(product.id + " " + product.title + " " + product.price);
        }
        System.out.println();
    }
}
