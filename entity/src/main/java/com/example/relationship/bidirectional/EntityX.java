package com.example.relationship.bidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="EntityX")
public class EntityX {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameX;

    // @JoinColumn 이 사용되고 mappedBy 속성이 없는 엔티티가 관계의 주인이 된다.
    // 관계의 주인은 외래키를 관리하는 엔티티를 말한다.
    // 예를 들어 관계의 주인이 아닌쪽(EntityY) 에서 외래키를 변경 할 경우 실제 테이블에는 반영되지 않는다.
    // 반대로 관계의 주인이 외래키를 변경 할 경우에는 실제 테이블에 반영이 된다.
    // 외래키를 제외한 나머지 필드에 대한 변경은 2개의 엔티티 모두 실제 테이블에 반영이 된다.
    @ManyToOne
    @JoinColumn(name = "ENTITY_Y_ID")
    private EntityY entityY;
}
