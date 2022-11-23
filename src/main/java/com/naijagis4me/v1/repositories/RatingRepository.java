package com.naijagis4me.v1.repositories;

import com.naijagis4me.v1.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
