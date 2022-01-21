package com.gl.ibuysu.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "auctions")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Purchaser purchaser;

    @ManyToOne
    private ArticleAuction articleAuction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchaser getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(Purchaser purchaser) {
        this.purchaser = purchaser;
    }

    public ArticleAuction getArticleAuction() {
        return articleAuction;
    }

    public void setArticleAuction(ArticleAuction articleAuction) {
        this.articleAuction = articleAuction;
    }

}