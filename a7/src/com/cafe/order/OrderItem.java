package com.cafe.order;

import com.cafe.menu.*;

public class OrderItem {
    private Beverage beverage;
    private int quantity;

    public OrderItem(Beverage beverage, int quantity){
        this.beverage = beverage;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        //name=Chamomile, Price=4100, size=TALL  +  quantity=2
        return beverage.toString()+", quantity="+quantity;
    }
}
