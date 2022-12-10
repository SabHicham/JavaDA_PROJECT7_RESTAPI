package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface CurvePointService {
    List<CurvePoint> findAll();
    void save(CurvePoint curvePoint);


    CurvePoint findById(Integer id);

    void deleteById(Integer id);
}
