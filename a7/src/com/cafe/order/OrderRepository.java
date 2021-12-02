package com.cafe.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository implements Iterator<Order> {
    List<Order> orders = new ArrayList<>();
    static int orderNo; // 주문번호
    int cur=0;


    public void add(Order order) { //주문 대기열에 넣으면서 order의 주문번호 부여해줌
        order.setOrderNo(++orderNo); //일케 해도 되는지는 함 보자!
        orders.add(order);
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder("");
        ans.append("\n--- 주문 관리자 화면 ---");
        ans.append("\n현재 주문수는 총 "+(3-cur)+" 입니다.\n\n< 주문 내역 >\n");
        for (int i=cur;i<orders.size();++i) {
            ans.append(orders.get(i).toString());
            ans.append("\n");
        }
        return String.valueOf(ans);
    }

    @Override
    public boolean hasNext() {
        return cur!=orders.size();
    }

    @Override
    public Order next() {
        if (hasNext()) return orders.get(cur++);
        else return null;
    }
}
