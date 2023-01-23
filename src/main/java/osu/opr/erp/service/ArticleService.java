package osu.opr.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osu.opr.erp.entity.Article;
import osu.opr.erp.repository.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findArticleByID(Long id) {
        return articleRepository.findById(id).get();
    }

    public void deleteArticlebyId(Long id) {
        articleRepository.deleteById(id);
    }

}
