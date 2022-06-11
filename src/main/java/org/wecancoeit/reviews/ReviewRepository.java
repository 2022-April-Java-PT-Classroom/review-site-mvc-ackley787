package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {

    Map<Long, Review> reviewList = new HashMap<>();

    public ReviewRepository() {
        Review monsterTruck = new Review(1L, "Traxxas E-Revo VXL",
                "/images/E-Revo-VXL-2.jpg",
                "Electric Monster Truck",
                "1/10 scale Monster Truck that is 4 wheel drive and powered by a electric brushless motor capable of handling 6s power.");

        Review microCrawler = new Review(2L, "Axial Scx24 Limited Edition B-17 Betty",
                "/images/B-17-Betty.jpg",
                "Micro Crawler", "1/24 scale crawler that is 4wd and is powered by 88t brushed motor. It is capable to crawl indoors or outside.");

        Review nitroMonsterTruck = new Review(3L, "Traxxas Revo 3.3",
                "/images/Revo-3.3.jpg",
                "Nitro Monster Truck", "1/10 scale Monster Truck that is 4wd and powered by a Nitro engine");

        Review stadiumTruck = new Review(4L, "Traxxas Rustler 4x4 VXL",
                "/images/Rustler-4x4-VXL.jpg",
                "Stadium Truck", "1/10 scale Stadium Truck that is 4wd and powered by electric brushless motor capable of handling 3s power.");

        Review shortCourseTruck = new Review(5L, "Traxxas Slash 4x4 Ultimate",
                "/images/Slash-4x4.jpg",
                "Short Course Truck", "1/10 scale Short Course Truck that is 4wd and powered by electric brushless motor capable of handling 3s power.");

        Review buggy = new Review(6L, "Arma Typhon 6s BLX",
                "/images/TYPHON-6S-BLX.jpg",
                "Buggy", "1/8 scale 4wd buggy powered by a electric brushless motor capable of handling 6s power.");

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
