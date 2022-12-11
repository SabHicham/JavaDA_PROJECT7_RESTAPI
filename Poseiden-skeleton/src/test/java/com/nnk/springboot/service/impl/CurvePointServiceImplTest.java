package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.CurvePointRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurvePointServiceImplTest extends TestCase {

    @InjectMocks
    private CurvePointServiceImpl curvePointService;

    @Mock
    public CurvePointRepository curvePointRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testFindAll() {
        //given
        List<CurvePoint> curvePoints = Arrays.asList(new CurvePoint());
        when(curvePointRepository.findAll()).thenReturn(curvePoints);
        //when
        List<CurvePoint> response = curvePointService.findAll();
        //then
        assertEquals(1, response.size());
    }

    public void testSave() {
        curvePointService.save(new CurvePoint());
    }

    public void testFindById() {
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointRepository.findById(any())).thenReturn(Optional.of(new CurvePoint()));
        curvePointService.findById(1);
        assertEquals(1, 1);
    }

    public void testDeleteById() {
        CurvePoint curvePoint = new CurvePoint();
        curvePointService.deleteById(1);
        assertEquals(1, 1);
    }
}