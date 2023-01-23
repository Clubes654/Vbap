package osu.opr.erp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import osu.opr.erp.entity.Article;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void saveArticle(){
        Article article = Article.builder()
                .amount(15.0)
                .name("Věšák")
                .pricePerUnit(11.0)
                .unit("ks")
                .build();
        Article article2 = Article.builder()
                .amount(15.0)
                .name("Čokoláda")
                .pricePerUnit(11.0)
                .unit("kg")
                .build();
        Article article3 = Article.builder()
                .amount(15.0)
                .name("Bonbon")
                .pricePerUnit(11.0)
                .unit("kg")
                .build();
        Article articl4 = Article.builder()
                .amount(15.0)
                .name("Tričko")
                .pricePerUnit(11.0)
                .unit("ks")
                .build();
        articleRepository.save(article);
        articleRepository.save(article2);
        articleRepository.save(article3);
        articleRepository.save(articl4);
    }

    @Test
    public void printAllArticle(){
        List<Article> articles = articleRepository.findAll();

        System.out.println(articles);
    }


}