package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TradeServiceImplTest extends TestCase {
    @InjectMocks
    private TradeServiceImpl tradeService;

    @Mock
    public TradeRepository tradeRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        //given
        List<Trade> trades = Arrays.asList(new Trade());
        when(tradeRepository.findAll()).thenReturn(trades);
        //when
        List<Trade> response = tradeService.findAll();
        //then
        assertEquals(1, response.size());
    }

    @Test
    public void testSave() {
        tradeService.save(new Trade());
        verify(tradeRepository, times(1)).save(any());
    }
    @Test
    public void testFindById() {

        when(tradeRepository.findById(any())).thenReturn(Optional.of(new Trade()));
        assertNotNull(tradeService.findById(1));
    }

    public void testDeleteById() {

        tradeService.deleteById(1);
        verify(tradeRepository, times(1)).deleteById(1);
    }
}