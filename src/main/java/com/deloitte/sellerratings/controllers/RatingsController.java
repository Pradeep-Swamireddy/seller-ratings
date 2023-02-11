package com.deloitte.sellerratings.controllers;

import com.deloitte.sellerratings.controllers.models.Rating;
import com.deloitte.sellerratings.services.RatingsService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

@Log4j2
@RestController
public class RatingsController {

    private final RatingsService ratingsService;

    @Autowired
    public RatingsController(final RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }

    @PostMapping("/ratings")
    public ResponseEntity<Object> saveRating(@RequestBody @Valid Rating rating) {
        Rating savedRating = ratingsService.saveRating(rating);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRating.getRatingId()).toUri()).build();
    }

    @GetMapping("/ratings/{sellerId}")
    public Map<String, String> getAggregateRatingBySellerId(@PathVariable String sellerId) {
        log.info("Fetching average rating of seller: {}", sellerId);
        return ratingsService.getAggregateRatingBySellerId(sellerId);
    }
}
