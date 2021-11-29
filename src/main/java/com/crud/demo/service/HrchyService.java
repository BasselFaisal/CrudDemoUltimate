package com.crud.demo.service;

import com.crud.demo.model.hrchy.Hrchy;
import com.crud.demo.repository.HrchyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrchyService {

    @Autowired
    private HrchyRepository hrchyRepository;


    public void saveHrchy(Hrchy hrchy) {
        hrchyRepository.save(hrchy);
    }
}
