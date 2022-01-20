package com.gl.ibuysu.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gl.ibuysu.utils.PurchaseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String picture;

    private String title;

    private String description;

    private double price;

    private PurchaseStatus purchaseStatus;

    private int sellerEvaluation;

    private int purchaserEvaluation;

    @JsonIgnoreProperties("articles")
    @ManyToMany
    @JoinTable(
            name="article_categories",
            joinColumns=@JoinColumn(name="article_id"),
            inverseJoinColumns = @JoinColumn(name = "article_category_id")
    )
    private List<ArticleCategory> categories = new ArrayList<> ();

    @JsonIgnoreProperties("articles")
    @ManyToMany
    @JoinTable(
            name="article_keywords",
            joinColumns=@JoinColumn(name="article_id "),
            inverseJoinColumns = @JoinColumn(name = "article_keyword_id")
    )
    private List<ArticleKeyword> keywords = new ArrayList<> ();

    @JsonIgnoreProperties("articles")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;

    @JsonIgnoreProperties("articles")
    @ManyToOne
    private Purchaser purchaser;

public Long getId() {
        return id;
}

public void setId(Long id) {
        this.id = id;
}

public String getPicture() {
        return picture;
}

public void setPicture(String picture) {
        this.picture = picture;
}

public String getTitle() {
        return title;
}

public void setTitle(String title) {
        this.title = title;
}

public String getDescription() {
        return description;
}

public void setDescription(String description) {
        this.description = description;
}

public double getPrice() {
        return price;
}

public void setPrice(double price) {
        this.price = price;
}

public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
}

public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
}

public int getSellerEvaluation() {
        return sellerEvaluation;
}

public void setSellerEvaluation(int sellerEvaluation) {
        this.sellerEvaluation = sellerEvaluation;
}

public int getPurchaserEvaluation() {
        return purchaserEvaluation;
}

public void setPurchaserEvaluation(int purchaserEvaluation) {
        this.purchaserEvaluation = purchaserEvaluation;
}

public List<ArticleCategory> getCategories() {
        return categories;
}

public void setCategories(List<ArticleCategory> categories) {
        this.categories = categories;
}

public List<ArticleKeyword> getKeywords() {
        return keywords;
}

public void setKeywords(List<ArticleKeyword> keywords) {
        this.keywords = keywords;
}

public Seller getSeller() {
        return seller;
}

public void setSeller(Seller seller) {
        this.seller = seller;
}

public Purchaser getPurchaser() {
        return purchaser;
}

public void setPurchaser(Purchaser purchaser) {
        this.purchaser = purchaser;
}

}
