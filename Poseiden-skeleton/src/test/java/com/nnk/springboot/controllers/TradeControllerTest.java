package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
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
public class TradeControllerTest extends TestCase {
    @InjectMocks
    private TradeController tradeController;

    @Mock
    public Model model;
    @Mock
    public TradeService tradeService;

    @Mock
    public BindingResult bindingResult;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    public void testHome() {
        String retour = tradeController.home(model);
        assertEquals("trade/list", retour);
    }

    public void testAddUser() {
        String retour = tradeController.addUser(null);
        assertEquals("trade/add", retour);
    }

    public void testValidate() {
        String retour = tradeController.validate(null, bindingResult, model);
        assertEquals("trade/add", retour);
    }

    public void testShowUpdateForm() {
        String retour = tradeController.showUpdateForm(null, model);
        assertEquals("trade/update", retour);
    }

    public void testUpdateTrade() {
        String retour = tradeController.updateTrade(null, new Trade(), bindingResult, model);
        assertEquals("redirect:/trade/list", retour);
    }

    public void testDeleteTrade() {
        String retour = tradeController.deleteTrade(null, model);
        assertEquals("redirect:/trade/list", retour);
    }
}