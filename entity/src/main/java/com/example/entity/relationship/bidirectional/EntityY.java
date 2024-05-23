package com.example.entity.relationship.bidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="EntityY")
public class EntityY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // mappedBy 속성을 사용하여 주인 엔티티의 @ManyToOne 이 사용된 필드명을 지정해 준다.
    // mappedBy 속성이 사용된 엔티티는 관계의 주인이 아니며 사용되지 않은 쪽이 주인이 된다.
    @OneToMany(mappedBy = "entityY")
    private List<EntityX> nameY;

    // 연관관계 편의 메소드
    // 데이터의 일관성을 유지하기 추가 할때 사용한다.
    public void addEntityX(EntityX entityX) {
        nameY.add(entityX);
        entityX.setEntityY(this);
    }

    // 연관관계 편의 메소드
    // 데이터의 일관성을 유지하기 삭제 할때 사용한다.
    public void removeEntityX(EntityX entityX) {
        nameY.remove(entityX);
        entityX.setEntityY(null);
    }
}