package hello.itemservice.repository;

import lombok.Data;

//Repository 에서 사용되는 객체 이기때문에
//package 흐름상 Repository 밑에 있다.
//Service 밑에 있으면 의존 관계 흐름이 깨지게 된다
//Repository 에서 필요한 부분인데 Service 단에 있으면 Repository 는 Service package를 의존하게 된다.
//DTO 위치는 마지막으로 사용되는 곳 하위에 두면 된다.
@Data
public class ItemUpdateDto {
    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemUpdateDto() {
    }

    public ItemUpdateDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
