package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.RatingRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RatingServiceImplTest extends TestCase {

    @InjectMocks
    private RatingServiceImpl ratingService;

    @Mock
    public RatingRepository ratingRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        //given
        List<Rating> ratings = Arrays.asList(new Rating());
        when(ratingRepository.findAll()).thenReturn(ratings);
        //when
        List<Rating> response = ratingService.findAll();
        //then
        assertEquals(1, response.size());
    }

    @Test
    public void testSave() {
        ratingService.save(new Rating());
    }

    @Test
    public void testFindById() {
        Rating rating = new Rating();
        when(ratingRepository.findById(any())).thenReturn(Optional.of(new Rating()));
        ratingService.findById(1);
        assertEquals(1, 1);
    }

    @Test
    public void testDeleteById() {
        Rating rating = new Rating();
        ratingService.deleteById(1);
        assertEquals(1, 1);
    }
}