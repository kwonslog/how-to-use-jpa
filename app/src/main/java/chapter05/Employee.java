package chapter05;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EMP_ID")
  private Long id;

  @Column(length = 25, nullable = false)
  private String name;

  @OneToOne(mappedBy = "employee")
  private EmployeeCard card;

  public void setEmployeeCard(EmployeeCard card) {
    this.card = card;
    card.setEmployee(this);
  }
}
