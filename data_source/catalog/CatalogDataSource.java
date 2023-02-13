package shopdata.data_source.catalog;

import shopdata.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class CatalogDataSource {
    public abstract ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator);
    public abstract ArrayList<Product> getCatalog(int page, int limit);
    public abstract Product productById(String id);

}
