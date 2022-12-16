package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;



import java.util.List;

public interface BidListService {

    List<BidList> findAll();

    void save(BidList bidList);


    BidList findById(Integer id);

    void deleteById(Integer id);



}
