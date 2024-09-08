package com.emazon.stock.configuration;

import com.emazon.stock.adapters.driven.jpa.mysql.adapter.ArticleAdapter;
import com.emazon.stock.adapters.driven.jpa.mysql.adapter.BrandAdapter;
import com.emazon.stock.adapters.driven.jpa.mysql.adapter.CategoryAdapter;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IArticleEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IArticleRepository;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.api.usecase.ArticleUseCase;
import com.emazon.stock.domain.api.usecase.BrandUseCase;
import com.emazon.stock.domain.api.usecase.CategoryUseCase;
import com.emazon.stock.domain.spi.IArticlePersistencePort;
import com.emazon.stock.domain.spi.IBrandPersistencePort;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;
    private final IArticleRepository articleRepository;
    private final IArticleEntityMapper articleEntityMapper;


    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandAdapter(brandRepository,brandEntityMapper);
    }

    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }

    @Bean
    public IArticlePersistencePort articlePersistencePort() {
        return new ArticleAdapter(articleRepository,articleEntityMapper);
    }
    @Bean
    public IArticleServicePort articleServicePort() {
        return new ArticleUseCase(articlePersistencePort());
    }

}
