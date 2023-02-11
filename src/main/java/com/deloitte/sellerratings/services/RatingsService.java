package com.deloitte.sellerratings.services;

import com.deloitte.sellerratings.controllers.models.Rating;
import com.deloitte.sellerratings.repositories.RatingsRepository;
import com.deloitte.sellerratings.repositories.documents.RatingsDocument;
import com.deloitte.sellerratings.services.mappers.RatingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@Service
public class RatingsService {

    private final RatingsRepository ratingsRepository;
    private final RatingsMapper ratingsMapper;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @Autowired
    public RatingsService(RatingsRepository ratingsRepository, final RatingsMapper ratingsMapper) {
        this.ratingsRepository = ratingsRepository;
        this.ratingsMapper = ratingsMapper;
    }

    public Rating saveRating(final Rating rating) {
        final RatingsDocument ratingsDocument = ratingsMapper.ratingToRatingsDocument(rating);
        final RatingsDocument savedDocument = ratingsRepository.save(ratingsDocument);
        return ratingsMapper.ratingsDocumentToRating(savedDocument);
    }

    public Map<String, String> getAggregateRatingBySellerId(final String sellerId) {
        final List<RatingsDocument> ratingsDocuments = ratingsRepository.findAllBySellerId(sellerId);

        decimalFormat.setRoundingMode(RoundingMode.UP);
        return Map.of(sellerId,decimalFormat.format(ratingsDocuments.stream().mapToDouble(r->r.getRating()).average().orElse(0.0)));
    }
}
