package chapter05;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "employee")
@Entity
@Table(name = "S_EMP_CARD")
public class EmployeeCard {

  @Id
  @Column(name = "CARD_ID")
  private Long cardId; // 사원증 아이디

  @Column(name = "EXPIRE_DATE")
  private Date expireDate; // 사원증 만료 기간

  private String role; // 권한

  @MapsId
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "XXX_EMP_ID")
  private Employee employee;
}
