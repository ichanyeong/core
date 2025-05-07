package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;

public class Order {
    private Long memberId;
    private String itemName;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    private int itemPrice;
    private int discountPrice;
    int a=0x323234;//16진수
    public int calculatePrice(){
        return itemPrice-discountPrice;
    }
    @Override
    public String toString() {
        var a=new Member(1L,"name", Grade.VIP);//할당되는 상수나 정보의 자료형에 따라 결정됨
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}
