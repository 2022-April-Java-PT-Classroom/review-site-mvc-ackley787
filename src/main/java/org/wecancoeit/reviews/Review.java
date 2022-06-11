package org.wecancoeit.reviews;

public class Review {
    private long id;
    private String title;
    private String imageUrl;
    private String reviewCategory;
    private String description;

    public Review(long id, String title, String imageUrl, String reviewCategory, String description) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.reviewCategory = reviewCategory;
        this.description = description;
    }

    public Review() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getReviewCategory() {
        return reviewCategory;
    }

    public String getDescription() {
        return description;
    }

}
