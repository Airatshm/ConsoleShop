package shopdata.data_source.order;

import shopdata.models.Order;

public abstract class OrderDataSource {



    public abstract void createOrder(Order order);

    public abstract Order getOrder();
}
