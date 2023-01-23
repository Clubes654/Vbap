package osu.opr.erp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import osu.opr.erp.entity.Article;
import osu.opr.erp.entity.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void saveOrder(){

        Article article = articleRepository.findArticleById(1L);

    //    Order order = orderRepository.findOrderById(13l);

        Order order = orderRepository.findById(5L).get();

        order.addArticle(article);

        orderRepository.save(order);

    }

}