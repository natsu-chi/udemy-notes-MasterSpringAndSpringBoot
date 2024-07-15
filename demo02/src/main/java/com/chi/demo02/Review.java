package com.chi.demo02;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Model used for Spring Data JPA
@Entity
public class Review {
    @Id
    private long id;

    @Column(name = "reviewer_id")
    private long reviewerId;

    private String content;

    public Review() {}

    public Review(long id, long reviewerId, String content) {
        this.id = id;
        this.reviewerId = reviewerId;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

