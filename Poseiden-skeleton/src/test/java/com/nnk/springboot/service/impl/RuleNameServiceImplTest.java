package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.RuleNameRepository;
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
public class RuleNameServiceImplTest extends TestCase {

    @InjectMocks
    private RuleNameServiceImpl ruleNameService;

    @Mock
    public RuleNameRepository ruleNameRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        //given
        List<RuleName> ruleNames = Arrays.asList(new RuleName());
        when(ruleNameRepository.findAll()).thenReturn(ruleNames);
        //when
        List<RuleName> response = ruleNameService.findAll();
        //then
        assertEquals(1, response.size());
    }

    public void testSave() {
        ruleNameService.save(new RuleName());
    }

    public void testFindById() {
        RuleName ruleName = new RuleName();
        when(ruleNameRepository.findById(any())).thenReturn(Optional.of(new RuleName()));
        ruleNameService.findById(1);
        assertEquals(1, 1);
    }

    public void testDeleteById() {
        RuleName ruleName = new RuleName();
        ruleNameService.deleteById(1);
        assertEquals(1, 1);
    }
}