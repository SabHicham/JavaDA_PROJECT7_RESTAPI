package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.BidListService;
import com.nnk.springboot.service.CurvePointService;
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
public class CurveControllerTest extends TestCase {
    @InjectMocks
    private CurveController curveController;

    @Mock
    public Model model;
    @Mock
    public CurvePointService curvePointService;

    @Mock
    public BindingResult bindingResult;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    public void testHome() {
       String retour = curveController.home(model);
       assertEquals("curvePoint/list", retour);

    }

    public void testAddBidForm() {
        String retour = curveController.addBidForm(null);
        assertEquals("curvePoint/add", retour);
    }

    public void testValidate() {
        String retour = curveController.validate(null, null, model);
        assertEquals("curvePoint/add", retour);
    }

    public void testShowUpdateForm() {
        String retour = curveController.showUpdateForm(1, model);
        assertEquals("curvePoint/update", retour);
    }

    public void testUpdateBid() {
        String retour = curveController.updateBid(null, new CurvePoint(1), bindingResult, model);
        assertEquals("redirect:/curvePoint/list", retour);
    }

    public void testDeleteBid() {
        String retour = curveController.deleteBid(null, model);
        assertEquals("redirect:/curvePoint/list", retour);

    }
}