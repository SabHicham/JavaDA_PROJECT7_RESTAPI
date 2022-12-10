package com.nnk.springboot.service.impl;


import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    public TradeRepository tradeRepository;

    @Override
    public List<Trade> findAll() {
        List<Trade> trades = tradeRepository.findAll();
        return trades;
    }

    @Override
    public void save(Trade trade) {
        tradeRepository.save(trade);

    }

    @Override
    public Trade findById(Integer id) {
        return tradeRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        tradeRepository.deleteById(id);
    }
}
