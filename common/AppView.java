package shopdata.common;

import shopdata.comporators.AppComparator;
import shopdata.models.Product;

import java.util.ArrayList;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public int nowPage = 0;
    public boolean hasNextPage = false;
    public final ArrayList<AppComparator<Product>> availableComparators = new ArrayList<>();
    public AppComparator selectedComparator;

    protected AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;

    }

    public void action(){};

}
