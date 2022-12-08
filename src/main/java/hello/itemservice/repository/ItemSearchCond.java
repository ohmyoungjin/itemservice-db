package hello.itemservice.repository;

import lombok.Data;

//Repository 에서 사용되는 객체 이기때문에
//package 흐름상 Repository 밑에 있다.
//Service 밑에 있으면 의존 관계 흐름이 깨지게 된다
//Repository 에서 필요한 부분인데 Service 단에 있으면 Repository 는 Service package를 의존하게 된다.
@Data
public class ItemSearchCond {

    private String itemName;
    private Integer maxPrice;

    public ItemSearchCond() {
    }

    public ItemSearchCond(String itemName, Integer maxPrice) {
        this.itemName = itemName;
        this.maxPrice = maxPrice;
    }
}
