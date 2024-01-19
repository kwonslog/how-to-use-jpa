package test.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserA {

    @Id
    // 아래 어노테이션 적용시 오류가 발생한다. 따로 h2 db 를 실행하는 형태로 해야 할까?
    // 테스트를 위해 직접 값을 넣는 방식으로 진행
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
