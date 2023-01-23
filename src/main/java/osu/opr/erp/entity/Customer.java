package osu.opr.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "name should have at least 2 char")
    private String name;
    @NotEmpty
    private String adress;
    @NotEmpty
    private String phoneNumber;
    private String note;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

}
