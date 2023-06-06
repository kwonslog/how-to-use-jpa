package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
public class EmployeeVO {

  @Id
  private Long id;

  private String name;

  @Column(name = "START_DATE")
  private Timestamp startDate;

  private String title;

  @Column(name = "DEPT_NAME")
  private String deptName;

  private Double salary;

  private String email;
}
