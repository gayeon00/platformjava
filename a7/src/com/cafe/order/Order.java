package com.cafe.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Order.PickUp delivery; // 한 고객의 order가 어떻게 배달될지 결정
    private List<OrderItem> items = new ArrayList<>(); // 커피 1개, 블렌드 1개 주세염

    private static int orderCount = 1; //커피 하나만 했으면 1(일단 오더 만들어지면 1개는 무적권 주문
    private int orderNo;

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void completed() {
        delivery.handle(this);


    }

    public void setPickUp(PickUp pickUp) {
        delivery = pickUp;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        orderCount++;
    }

    public static interface PickUp{
        public abstract void handle(Order o);
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder("주문번호: " + orderNo + " - [");
        for (OrderItem item:items) {
            ans.append(item.toString());
            ans.append(", ");
        }
        ans.append("]");
        return String.valueOf(ans);
    }

}
