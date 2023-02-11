package com.deloitte.sellerratings.services.mappers;

import com.deloitte.sellerratings.controllers.models.Rating;
import com.deloitte.sellerratings.repositories.documents.RatingsDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingsMapper {
    RatingsDocument ratingToRatingsDocument (Rating classified);

    Rating ratingsDocumentToRating(RatingsDocument classified);
}
