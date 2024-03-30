package com.process.shop.service.Article;
// ArticleRepository.java
import com.process.shop.model.Article;
import com.process.shop.model.Category;
import com.process.shop.repository.ArticleRepository;
import com.process.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article createArticle(Article article) {
        // Verificar si la categoría ya tiene algún artículo asociado
        if (article.getCategory() != null && article.getCategory().getArticles() != null
                && !article.getCategory().getArticles().isEmpty()) {
            throw new RuntimeException("La categoría ya tiene un artículo asociado. Solo se permite un artículo por categoría.");
        }
        return articleRepository.save(article);
    }

    @Override
    public Article getArticleById(Long id) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        return articleOptional.orElse(null);
    }

    @Override
    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article updateArticle(Article article, Long id) {
        // Implementar la actualización del artículo
        return article;
    }
}