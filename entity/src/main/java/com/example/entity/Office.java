package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Office")
public class Office extends DateEntity {

    // @Id 는 DateEntity 안에 정의된 값을 사용한다.

    private String name;

    // @JoinColumn 에 사용된 컬럼명은 SubAddressListTable 안에 추가 된다.
    // OFFICE_ID 값은 Office 엔티티의 id 값을 참조하는 외래키로 설정된다.
    @ElementCollection
    @CollectionTable(name = "SubAddressListTable", joinColumns = @JoinColumn(name = "OFFICE_ID"))
    @Column(name = "address")
    private List<Address> addressList;
}
