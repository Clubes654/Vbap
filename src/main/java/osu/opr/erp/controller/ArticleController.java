package osu.opr.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osu.opr.erp.entity.Article;
import osu.opr.erp.exception.ResourceNotFoundException;
import osu.opr.erp.service.ArticleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/")
    public Article saveArticle(@Valid @RequestBody Article article){
        return articleService.saveArticle(article);
    }

    @GetMapping("/")
    public List<Article> findAll(){
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article findArticleById(@PathVariable Long id){
        try{
            Article article = articleService.findArticleByID(id);
            return article;
        }catch (Exception e){
            throw new ResourceNotFoundException();
        }

    }


    @PostMapping("/{id}")
    public Article replaceArticlebyId(@Valid @RequestBody Article newArticle, @PathVariable Long id){
        Article exp = articleService.findArticleByID(id);
        exp.setAmount(newArticle.getAmount());
        exp.setName(newArticle.getName());
        exp.setUnit(newArticle.getUnit());
        exp.setPricePerUnit(newArticle.getPricePerUnit());
        articleService.saveArticle(exp);
        return exp;
    }
    @DeleteMapping("/{id}")
    public void deleteArticlebyId(@PathVariable Long id){
        articleService.deleteArticlebyId(id);
    }


}
