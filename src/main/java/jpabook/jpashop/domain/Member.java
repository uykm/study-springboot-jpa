package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장 타입 : 둘 중에 한 곳에서만 선언해줘도 되는데, 모두 해주는 편
    private Address address;

    @OneToMany(mappedBy = "member") // Order 테이블의 외래 키(FK) 값을 변경해도 이 값은 바뀌지 않는다.
    private List<Order> orders = new ArrayList<>();

}