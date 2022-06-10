package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {

    Map<Long, Review> reviewList = new HashMap<>();

    public ReviewRepository() {
        Review monsterTruck = new Review(1L, "Monster Truck",
                "src/main/resources/static/images/E-Revo VXL 2.jpg",
                "Monster Truck");
        Review microCrawler = new Review(2L, "Micro Crawler",
                "src/main/resources/static/images/B-17 Betty.jpg",
                "Micro Crawler");
        Review nitroMonsterTruck = new Review(3L, "Nitro Monster Truck",
                "src/main/resources/static/images/Revo 3.3.jpg",
                "Nitro Monster Truck");
        Review stadiumTruck = new Review(4L, "Stadium Truck",
                "src/main/resources/static/images/Rustler 4x4 VXL.jpg",
                "Stadium Truck");
        Review shortCourseTruck = new Review(5L, "Short Course Truck",
                "src/main/resources/static/images/Slash 4x4.jpg",
                "Short Course Truck");
        Review buggy = new Review(6L, "Buggy",
                "src/main/resources/static/images/TYPHON 6S BLX.jpg",
                "Buggy");

        reviewList.put(monsterTruck.getId(), monsterTruck);
        reviewList.put(microCrawler.getId(), microCrawler);
        reviewList.put(nitroMonsterTruck.getId(), nitroMonsterTruck);
        reviewList.put(stadiumTruck.getId(), stadiumTruck);
        reviewList.put(shortCourseTruck.getId(), shortCourseTruck);
        reviewList.put(buggy.getId(), buggy);

    }

    public ReviewRepository(Review... reviewToAdd) {
        for (Review review : reviewToAdd) {
            reviewList.put(review.getId(), review);
        }

    }

    public Review findOne(long id) {

        return reviewList.get(id);
    }

    public Collection<Review> findAll() {

        return reviewList.values();
    }
}
