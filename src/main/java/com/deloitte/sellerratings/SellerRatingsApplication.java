package com.deloitte.sellerratings;

import com.deloitte.sellerratings.repositories.RatingsRepository;
import com.deloitte.sellerratings.repositories.documents.RatingsDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class SellerRatingsApplication implements CommandLineRunner {

    @Autowired
    private RatingsRepository ratingsRepository;

    public static void main(String[] args) {
        SpringApplication.run(SellerRatingsApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        List<String> sellers = List.of("Pradeep", "Souji", "Bhanu", "Vinodh");
        List<String> buyers = List.of("John", "Jane", "Mike", "Michelle", "Mary", "Estelle", "Ricardo", "Dan");
        final List<RatingsDocument> ratings = Stream.generate(new Random()::nextInt)
                .limit(9906).map(i -> {
                    int absI = Math.abs(i);
                    if (i > 100000) {
                        absI = absI / 100000;
                    }
                    String sellerId = sellers.get(absI % sellers.size());
                    String buyerId = buyers.get(absI % buyers.size());
                    int rating = (absI % 5) + 1;
                    String description = "My experience was :" + i;
                    return new RatingsDocument(null, sellerId, rating, buyerId, description);
                }).toList();
        ratingsRepository.saveAll(ratings);
    }
}
