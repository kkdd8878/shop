package com.bitc.shop.dto;

import com.bitc.shop.constant.OrderStatus;
import com.bitc.shop.entity.Order;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderHistDto {
//    주문이력에 관련된 데이터 저장하는 클래스
//    주문 정보를 가져옴

    public OrderHistDto(Order order){
        this.orderId = order.getId();
//        사용자 지정방식으로 날짜 및 시간 저장
        this.orderDate = order.getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.orderStatus = order.getOrderStatus();
    }

    private Long orderId; // 주문아이디
    private String orderDate; // 주문날짜
    private OrderStatus orderStatus; // 주문 상태

    //주문 상품 리스트
    private List<OrderItemDto> orderItemDtoList = new ArrayList<>();

    public void addOrderItemDto(OrderItemDto orderItemDto){
        orderItemDtoList.add(orderItemDto);
    }

}
