package com.cafe.order;

import com.cafe.menu.*;

public class OrderTest {
    static PickUpFactory pickUpFactory = new PickUpFactory();

    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();

        orderRepository.add(makeOrderForDelivery()); //OrderRepository의 add method에 주문번호 올라가게 만들어줘야
        orderRepository.add(makeOrderForDriveThru());
        orderRepository.add(makeOrderForTakeOut());

        while (orderRepository.hasNext()){
            System.out.println(orderRepository); //OrderRepository 클래스에 toString 구현해줘야(현재 주문수 표시해줘야)
            Order order = orderRepository.next(); // order는 [아메리카노 2개, 티 1개] ==> 한 고객이 주문한 음료 "리스트"
            if (order==null) break;
            order.completed(); //알맞은 pickup에 전달해줘야함
        }
    }

    private static Order makeOrderForTakeOut(){ //takeout하는 고객 한명의 주문 리스트
        Order order = new Order(); //한 고객의 주문 리스트
        Order.PickUp pickUp = pickUpFactory.makeTakeOut(); //실제로는 PickUpFactory 클래스 아래 takeout객체로 나옴
        order.setPickUp(pickUp); // order의 pickup방법을 takeout객체로 넣어줌 (setpickup은 PickupFactory클래스로 선언된 멤버변수를 바꿔주는걸거임)
        order.addItem(new OrderItem(new Coffee("Chamomile"),1)); // order리스트에 [커피2개] 아이템 객체 넣음
        order.addItem(new OrderItem(new Coffee("Americano"),1)); // order리스트에 [커피2개] 아이템 객체 넣음
        return order;
    }

    private static Order makeOrderForDriveThru(){ //takeout하는 고객 한명의 주문 리스트
        Order order = new Order(); //한 고객의 주문 리스트
        Order.PickUp pickUp = pickUpFactory.makeDriveThru("001가0000"); //실제로는 PickUpFactory 클래스 아래 takeout객체로 나옴
        order.setPickUp(pickUp); // order의 pickup방법을 takeout객체로 넣어줌 (setpickup은 PickupFactory클래스로 선언된 멤버변수를 바꿔주는걸거임)
        order.addItem(new OrderItem(new Coffee("Americano"),2)); // order리스트에 [커피2개] 아이템 객체 넣음
        return order;
    }

    private static Order makeOrderForDelivery(){ //takeout하는 고객 한명의 주문 리스트
        Order order = new Order(); //한 고객의 주문 리스트
        Order.PickUp pickUp = pickUpFactory.makeDelivery("Pusan National University"); //실제로는 PickUpFactory 클래스 아래 takeout객체로 나옴
        order.setPickUp(pickUp); // order의 pickup방법을 takeout객체로 넣어줌 (setpickup은 PickupFactory클래스로 선언된 멤버변수를 바꿔주는걸거임)
        order.addItem(new OrderItem(new Blended("MangoBanana"),1)); // order리스트에 [커피2개] 아이템 객체 넣음
        order.addItem(new OrderItem(new Coffee("Americano"),1)); // order리스트에 [커피2개] 아이템 객체 넣음
        return order;
    }
}
