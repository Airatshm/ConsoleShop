package shopdata.data_source.catalog;

import shopdata.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class MockCatalogDataSourceImpl extends  CatalogDataSource {
    @Override
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator) {
        ArrayList<Product> products = generateProducts();
        Stream<Product> productStream = products.stream().filter(p->p.available).sorted(comparator).skip((long) page * limit).limit(limit);
        return new ArrayList<>(productStream.toList());
    }

    @Override
    public ArrayList<Product> getCatalog(int page, int limit) {
        ArrayList<Product> products = generateProducts();
        Stream<Product> productStream = products.stream().filter(p->p.available).skip((long) page * limit).limit(limit);
        return new ArrayList<>(productStream.toList());
    }

    @Override
    public Product productById(String id) {
        ArrayList<Product> products = getCatalog(0, 9999999);
        for (Product p : products) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    ArrayList<Product> generateProducts() {
        ArrayList<Product> products = new ArrayList<>();
        // добавление
        products.add(new Product("id1", "SmartPhone", "Best phone", 1000, true));
        products.add(new Product("id2", "Laptop", "Some phone", 2000, true));
        products.add(new Product("id3", "Watch", "Best watch", 500, true));
        products.add(new Product("id4", "Phone", "Simple phone", 100, true));
        for (int i = 0; i < 20; i++) {
            products.add(new Product("id" + (i + 5), "IPhone-" + i, "Simple phone", 100 + i * 100, i % 4 != 0));
        }
        return products;
    }
}

/*
dataSource
----------
services
----------
controllers
views


0...30
page 0 limit 10: 0...9
page 1 limit 10: 10...19
page 1 limit 7: 7...13
page 2 limit 7: 14...20
 */
