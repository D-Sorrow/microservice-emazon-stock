package com.emazon.stock.adapters.driven.jpa.mysql.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column(nullable = false)
    private String nameCategory;

    @Column(unique = true, nullable = false)
    private String descriptionCategory;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<ArticleEntity> articles;
}
