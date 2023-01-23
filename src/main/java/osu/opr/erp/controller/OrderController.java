package osu.opr.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osu.opr.erp.entity.Article;
import osu.opr.erp.entity.Order;
import osu.opr.erp.service.ArticleService;
import osu.opr.erp.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ArticleService articleService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id){
        return orderService.findOrderById(id);
    }

    @PutMapping("/{id}")
    public Order replaceOrderById(@Valid @RequestBody Order newOrder, @PathVariable Long id){
        Order order = orderService.findOrderById(id);
        order.setDescription(newOrder.getDescription());
        order.setArticles(newOrder.getArticles());
        orderService.saveOrder(order);
        return order;
    }

    @PostMapping("/{id}/article/{articleId}")
    public Order addArticleToOrder(@PathVariable Long id,@PathVariable Long articleId){
        Order order = orderService.findOrderById(id);
        Article article = articleService.findArticleByID(articleId);
        order.addArticle(article);
        orderService.saveOrder(order);
        return order;
    }

    @PostMapping("/{id}/article")
    public Order createArticleToOrder(@PathVariable Long id, @RequestBody Article article){
        Order order = orderService.findOrderById(id);
        articleService.saveArticle(article);
        order.addArticle(article);
        orderService.saveOrder(order);
        return order;
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id){
        orderService.deleteOrderById(id);
    }

}
