package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @JsonIgnore
    @OneToMany(mappedBy = "member") // Order 테이블의 외래 키(FK) 값을 변경해도 이 값은 바뀌지 않는다.
    private List<Order> orders = new ArrayList<>();

}

