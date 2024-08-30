package com.emazon.stock.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idArticle;

    @Column(nullable = false)
    private String nameArticle;

    @Column(nullable = false)
    private String descriptionArticle;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "idArticle", referencedColumnName = "idArticle"),
            inverseJoinColumns = @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    )
    private Set<CategoryEntity> categories;
}
