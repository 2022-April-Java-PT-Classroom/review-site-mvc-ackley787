package org.wecancoeit.reviews;

public class Review {
    private long id;
    private String title;
    private String imageUrl;
    private String reviewCategory;

    public Long getId() {
        return id;
    }
    public Review(long id, String title, String imageUrl, String reviewCategory) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.reviewCategory = reviewCategory;
    }
    public Review(){

    }

}
