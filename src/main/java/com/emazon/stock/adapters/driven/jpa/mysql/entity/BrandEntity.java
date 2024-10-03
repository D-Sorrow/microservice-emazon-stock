package com.emazon.stock.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Table(name = "brand")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    @Column(unique = true, nullable = false)
    private String brandName;

    @Column(unique = true, nullable = false)
    private String brandDescription;

    @OneToMany(mappedBy = "brand")
    @ToString.Exclude
    private List<ArticleEntity> articles;

}
