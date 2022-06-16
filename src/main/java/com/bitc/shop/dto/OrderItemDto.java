package com.bitc.shop.dto;

import com.bitc.shop.entity.OrderItem;
import lombok.Data;

@Data
public class OrderItemDto {
// 생성자를 사용하여 주문하는 상품의 정보와 실제 이미지의 위치를 받아옴
    public OrderItemDto(OrderItem orderItem, String imgUrl){
        this.itemNm = orderItem.getItem().getItemNm();
        this.count = orderItem.getCount();
        this.orderPrice =  orderItem.getOrderPrice();
        this.imgUrl = imgUrl;
    }
    private String itemNm; //상품명
    private int count; //주문수량
    private int orderPrice; // 주문금액
    private String imgUrl; // 상품 이미지 경로
}
