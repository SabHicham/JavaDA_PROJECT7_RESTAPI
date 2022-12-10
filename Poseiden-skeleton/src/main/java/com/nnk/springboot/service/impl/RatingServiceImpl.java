package com.nnk.springboot.service.impl;


import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    public RatingRepository ratingRepository;

    @Override
    public List<Rating> findAll() {
        List<Rating> ratings = ratingRepository.findAll();
        return ratings;
    }

    @Override
    public void save(Rating rating) {
        ratingRepository.save(rating);

    }

    @Override
    public Rating findById(Integer id) {
        return ratingRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        ratingRepository.deleteById(id);
    }
}
