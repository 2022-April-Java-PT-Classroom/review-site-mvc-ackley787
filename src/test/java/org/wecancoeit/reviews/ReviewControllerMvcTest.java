package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReviewController.class)
public class ReviewControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewRepository reviewRepo;

    @Mock
    private Review reviewOne = new Review(1L, "Traxxas E-Revo VXL",
            "src/main/resources/static/images/E-Revo VXL 2.jpg",
            "Electric Monster Truck",
            "1/10 scale Monster Truck that is 4 wheel drive and powered by a electric brushless motor capable of handling 6s power.");

    @Mock
    private Review reviewTwo = new Review(2L, "Axial Scx24 Limited Edition B-17 Betty",
            "src/main/resources/static/images/B-17 Betty.jpg",
            "Micro Crawler", "1/24 scale crawler that is 4wd and is powered by 88t brushed motor. It is capable to crawl indoors or outside.");

    @Test
    public void shouldBeOkForAllReviewsInTheReviewsTemplate() throws Exception {
        mockMvc.perform(get("/reviews")).andExpect(status().isOk())
                .andExpect(view().name("reviewsTemplate"));
    }

    @Test
    public void shouldFindAllReviewsInModel() throws Exception {
        Collection<Review> allReviewsInModel = Arrays.asList(reviewOne, reviewTwo);
        when(reviewRepo.findAll()).thenReturn(allReviewsInModel);
        mockMvc.perform(get("/reviews"))
                .andExpect(model().attribute("reviewsModel", allReviewsInModel));
    }

    @Test
    public void shouldBeOkOneReviewInTheReviewTemplate() throws Exception {
        Long reviewOneId = 1L;
        when(reviewRepo.findOne(reviewOneId)).thenReturn(reviewOne);
        mockMvc.perform(get("/review?id=1")).andExpect(status().isOk())
                .andExpect(view().name("reviewTemplate"));
    }

    @Test
    public void shouldFindReviewOneInModel() throws Exception {
        Long reviewOneId = 1L;
        when(reviewRepo.findOne(reviewOneId)).thenReturn(reviewOne);
        mockMvc.perform(get("/review?id=1"))
                .andExpect(model().attribute("reviewModel", reviewOne));
    }

    @Test
    public void shouldBeNotFoundForRequestNotInModel() throws Exception {
        Long reviewTwoId = 2L;
        when(reviewRepo.findOne(reviewTwoId)).thenReturn(reviewTwo);
        mockMvc.perform(get("/review?id=3")).andExpect(status().isNotFound());
    }

}
