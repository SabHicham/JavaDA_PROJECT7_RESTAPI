package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.CurvePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointServiceImpl implements CurvePointService {
    @Autowired
    public CurvePointRepository curvePointRepository;

    @Override
    public List<CurvePoint> findAll() {
        List<CurvePoint> curvePoints = curvePointRepository.findAll();
        return curvePoints;
    }

    @Override
    public void save(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);

    }

    @Override
    public CurvePoint findById(Integer id) {
        return curvePointRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        curvePointRepository.deleteById(id);
    }
}
