package osu.opr.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osu.opr.erp.entity.Article;
import osu.opr.erp.entity.Order;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    public Article findArticleById(Long id);


}
