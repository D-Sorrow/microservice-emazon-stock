package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.IArticlePersistencePort;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }


    @Override
    public void saveArticle(Article article) {
        if(article.getNameArticle().isEmpty() || article.getDescriptionArticle().isEmpty()
                || article.getPrice() == null || article.getStock() == null || article.getCategories().isEmpty()){
                throw new IllegalArgumentException("Article should not be null or empty");
        }
        if (Boolean.TRUE.equals(validCategoryRepeat(article.getCategories()))) {
            throw new IllegalArgumentException("There are repeat categories in list");
        }
        if (article.getCategories().size() > 3 || article.getCategories().isEmpty()) {
            throw new IllegalArgumentException("There are no categories in list");
        }

        this.articlePersistencePort.saveArticle(article);
    }

    @Override
    public List<Article> getArticles() {
        return List.of();
    }

    @Override
    public Article getArticle(String id) {
        return null;
    }

    @Override
    public void deleteArticle(String id) {

    }

    @Override
    public void updateArticle(Article article) {

    }
    public static Boolean validCategoryRepeat(List<Category> categories){
        List<Long> idList = categories.stream()
                .map(Category::getIdCategory)
                .toList();
        Set<Long> idSet = new HashSet<>(idList);
        return idList.size() != idSet.size();
    }

}
