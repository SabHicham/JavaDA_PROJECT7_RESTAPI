package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;

import java.util.List;

public interface BidListService {

    List<BidList> findBidList ();

    void save(BidList bidList);


    BidList findById(Integer id);

    void deleteById(Integer id);
}
