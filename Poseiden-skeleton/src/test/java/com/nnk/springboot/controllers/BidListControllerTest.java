package com.nnk.springboot.controllers;


import com.nnk.springboot.service.BidListService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BidListControllerTest extends TestCase {

    @InjectMocks
    private BidListController bidListController;

    @Mock
    public Model model;
    @Mock
    public BidListService bidListService;

    @Mock
    public BindingResult bindingResult;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testHome() {


        String retour = bidListController.home(model);
        assertEquals("bidList/list", retour);


    }
    @Test
    public void testAddBidForm() {
        String retour = bidListController.addBidForm(null);
        assertEquals("bidList/add", retour);
    }
    @Test
    public void testValidate() {
        when(bindingResult.hasErrors()).thenReturn(false);
        String retour = bidListController.validate(null, bindingResult, model);
        assertEquals("redirect:/bidList/list", retour);
    }
    @Test
    public void testValidateError() {
        when(bindingResult.hasErrors()).thenReturn(true);
        String retour = bidListController.validate(null, bindingResult, model);
        assertEquals("bidList/add", retour);
    }
    @Test
    public void testShowUpdateForm() {
       String retour =  bidListController.showUpdateForm(null, model);
       assertEquals("bidList/update", retour);
    }


    /*@Test
    public void testUpdateBid() {
        String retour = bidListController.updateBid(null, new BidList(), null, model );
        assertEquals("redirect:/bidList/list", retour);

    }*/
    @Test
    public void testDeleteBid() {
        String retour = bidListController.deleteBid(null, model);
        assertEquals("redirect:/bidList/list", retour);
    }
}