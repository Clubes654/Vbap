package osu.opr.erp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "_article")
public class Article {

    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Name may not be empty")
    private String name;
    @NotNull(message = "amount may not be empty")
    private Double amount;
    @NotNull(message = "pricePerUnit may not be empty")
    private Double pricePerUnit;
    @NotEmpty(message = "unit may not be empty")
    private String unit;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "articles",
            cascade = CascadeType.ALL
    )
    private List<Order> orders;


}
