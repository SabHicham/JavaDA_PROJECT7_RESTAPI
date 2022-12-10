package com.nnk.springboot.service;


import com.nnk.springboot.domain.Trade;

import java.util.List;


public interface TradeService {

    List<Trade> findAll ();

    void save(Trade trade);


    Trade findById(Integer id);

    void deleteById(Integer id);
}
