package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.RuleNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameServiceImpl implements RuleNameService {
    @Autowired
    public RuleNameRepository ruleNameRepository;

    @Override
    public List<RuleName> findAll() {
        List<RuleName> ruleNames = ruleNameRepository.findAll();
        return ruleNames;
    }

    @Override
    public void save(RuleName ruleName) {
        ruleNameRepository.save(ruleName);

    }

    @Override
    public RuleName findById(Integer id) {
        return ruleNameRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        ruleNameRepository.deleteById(id);
    }
}
