package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.constants.ConstantsDomain;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.IArticlePersistencePort;
import com.emazon.stock.domain.util.ResponsePage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static com.emazon.stock.domain.constants.ConstantsDomain.CONTROLLER_REGULAR_EXPRESSION_SORT_DIRECTION;


public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }


    @Override
    public void saveArticle(Article article) {
        if(article.getNameArticle().isEmpty() || article.getDescriptionArticle().isEmpty()
                || article.getPrice() == ConstantsDomain.DATA_NULL_BIG_DECIMAL ||
                article.getStock() == ConstantsDomain.DATA_NULL_INT || article.getCategories().isEmpty()){
                throw new IllegalArgumentException();
        }
        if (Boolean.TRUE.equals(validCategoryRepeat(article.getCategories()))) {
            throw new IllegalArgumentException();
        }
        if (article.getCategories().size() > ConstantsDomain.SIZE_INVALID_TO_ARTICLE || article.getCategories().isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.articlePersistencePort.saveArticle(article);
    }

    @Override
    public ResponsePage<Article> getArticles(int page, int size, String sortDirection, String sortBy) {

        Pattern patternSort = Pattern.compile(CONTROLLER_REGULAR_EXPRESSION_SORT_DIRECTION);

        if(!patternSort.matcher(sortDirection).find()){
            throw new IllegalArgumentException();
        }
        return articlePersistencePort.getArticles(page, size, sortDirection, sortBy);
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
