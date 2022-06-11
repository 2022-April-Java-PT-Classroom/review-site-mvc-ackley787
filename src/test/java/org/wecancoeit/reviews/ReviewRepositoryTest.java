package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTest {

    private final Review reviewOne = new Review(1L, "Traxxas E-Revo VXL",
            "src/main/resources/static/images/E-Revo VXL 2.jpg",
            "Electric Monster Truck",
            "1/10 scale Monster Truck that is 4 wheel drive and powered by a electric brushless motor capable of handling 6s power.");

    private final Review reviewTwo = new Review(2L, "Axial Scx24 Limited Edition B-17 Betty",
            "src/main/resources/static/images/B-17 Betty.jpg",
            "Micro Crawler", "1/24 scale crawler that is 4wd and is powered by 88t brushed motor. It is capable to crawl indoors or outside.");
    private final ReviewRepository underTest = new ReviewRepository(reviewOne, reviewTwo);

    @Test
    public void shouldFindOneReview() {
        Review foundReview = underTest.findOne(1L);
        assertEquals(reviewOne, foundReview);

    }

    @Test
    public void shouldFindReviewOneAndReviewTwo() {
        Collection<Review> foundReviews = underTest.findAll();
        assertThat(foundReviews).contains(reviewOne, reviewOne);


    }


}
