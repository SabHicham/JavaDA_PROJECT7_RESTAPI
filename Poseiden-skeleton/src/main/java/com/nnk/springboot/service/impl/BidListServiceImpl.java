package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.BidListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BidListServiceImpl implements BidListService {
    @Autowired
    public BidListRepository bidListRepository;

    @Override
    public List<BidList> findAll() {
        List<BidList> bidLists = bidListRepository.findAll();
        return bidLists;
    }

    @Override
    public void save(BidList bidList) {
        bidListRepository.save(bidList);

    }

    @Override
    public BidList findById(Integer id) {
        return bidListRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        bidListRepository.deleteById(id);
    }
}
