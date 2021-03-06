package com.bitc.shop.entity;

import com.bitc.shop.constant.ItemSellStatus;
import com.bitc.shop.dto.ItemFormDto;
import com.bitc.shop.exception.OutOfStockException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity{
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 50)
    private String itemNm;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    public void removeStock(int stockNumber){
//        현재 재고량에서 판매할 재고량 빼기
        int restStock = this.stockNumber - stockNumber;
//        현재 재고량이 판매할 재고량보다 적을 경우 예외 발생
        if(restStock<0){
            throw new OutOfStockException("상품의 재고가 부족합니다.(현재 재고 수량 : " + this.stockNumber + ")" );
        }
        this.stockNumber = restStock;
    }

    public void addStock(int stockNumber){
        this.stockNumber += stockNumber;
    }

}
