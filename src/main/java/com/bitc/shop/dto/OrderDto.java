package com.bitc.shop.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderDto {

    @NotNull(message = "상품아이디는 필수 입력 값입니다.")
    private  Long itemId;
// @Min,@Max : 지정한 멤버 변수에 최소, 최대값을 설정
    @Min(value = 1, message = "최소주문은 1개입니다.")
    @Max(value = 999, message = "최대 주문 수량은 999개 입니다.")
    private int count;
}
