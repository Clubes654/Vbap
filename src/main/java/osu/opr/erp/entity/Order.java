package osu.opr.erp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "desc1"
    )
    private String description;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "article_order_map",
            joinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "article_id",
                    referencedColumnName = "id"
            )

    )

    @NotEmpty
    private List<Article> articles;

    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL)
    private Customer customer;


    public void addArticle(Article article){
        if (articles == null) articles = new ArrayList<Article>();
        articles.add(article);
    }

}
