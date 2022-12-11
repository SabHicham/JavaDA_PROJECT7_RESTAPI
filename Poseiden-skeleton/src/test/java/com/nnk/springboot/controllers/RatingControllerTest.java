package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.BidListService;
import com.nnk.springboot.service.RatingService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
@ExtendWith(MockitoExtension.class)
public class RatingControllerTest extends TestCase {
    @InjectMocks
    private RatingController ratingController;

    @Mock
    public Model model;
    @Mock
    public RatingService ratingService;

    @Mock
    public BindingResult bindingResult;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    public void testHome() {
        String retour = ratingController.home(model);
        assertEquals("rating/list", retour);
    }

    public void testAddRatingForm() {
        String retour = ratingController.addRatingForm(null);
        assertEquals("rating/add", retour);
    }

    public void testValidate() {
        String retour = ratingController.validate(null, bindingResult, model);
        assertEquals("rating/add", retour);
    }

    public void testShowUpdateForm() {
        String retour = ratingController.showUpdateForm(null, model);
        assertEquals("rating/update", retour);
    }

    public void testUpdateRating() {
        String retour = ratingController.updateRating(null, new Rating(), null, model);
        assertEquals("redirect:/rating/list", retour);
    }

    public void testDeleteRating() {
        String retour = ratingController.deleteRating( null, model);
        assertEquals("redirect:/rating/list", retour);
    }
}