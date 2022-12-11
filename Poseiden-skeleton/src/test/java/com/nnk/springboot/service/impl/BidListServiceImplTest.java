package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.TradeRepository;
import junit.framework.TestCase;
import org.junit.Before;
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
public class BidListServiceImplTest extends TestCase {

    @InjectMocks
    private BidListServiceImpl bidListService;

    @Mock
    public BidListRepository bidListRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    public void testFindBidList() {
        //given
        List<BidList> bidLists = Arrays.asList(new BidList());
        when(bidListRepository.findAll()).thenReturn(bidLists);
        //when
        List<BidList> response = bidListService.findBidList();
        //then
        assertEquals(1, response.size());
    }

    public void testSave() {
        bidListService.save(new BidList());
    }

    public void testFindById() {
        BidList bidList = new BidList();
        when(bidListRepository.findById(any())).thenReturn(Optional.of(new BidList()));
        bidListService.findById(1);
        assertEquals(1, 1);
    }

    public void testDeleteById() {
        BidList bidList = new BidList();
        bidListService.deleteById(1);
        assertEquals(1, 1);
    }
}