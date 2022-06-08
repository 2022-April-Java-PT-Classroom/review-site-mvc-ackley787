package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTest {

    private Review reviewOne = new Review(1L,"titleOne","imageOne","one");
    private Review reviewTwo = new Review(2L,"titleTwo","imageTwo","two");
    private ReviewRepository underTest = new ReviewRepository(reviewOne, reviewTwo);

    @Test
    public void shouldFindOneReview(){
        Review foundReview = underTest.findOne(1L);
        assertEquals(reviewOne, foundReview);

    }
    @Test
    public void shouldFindReviewOneAndReviewTwo(){
        Collection<Review> foundReviews = underTest.findAll();
        assertThat(foundReviews).contains(reviewOne,reviewOne);


    }



}
