package com.crud.demo.service;

import com.crud.demo.model.hrchy.Hrchy;
import com.crud.demo.model.response.Response;
import com.crud.demo.model.user.User;
import com.crud.demo.repository.HrchyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrchyService {

    @Autowired
    private HrchyRepository hrchyRepository;


    public Response saveHrchy(Hrchy hrchy) {
        Response response = new Response();
        Hrchy hrchy1 =  hrchyRepository.save(hrchy);
        response.setSuccess(true);
        response.setData(hrchy1);
        return response;
    }

    public List<Hrchy> findAll() {
        List<Hrchy> hrchies=  hrchyRepository.findAll();
        return hrchies;
    }

    public Hrchy findById(int id) {
        return hrchyRepository.findById(id).get();
    }

    public Response UpdateHrchy(Hrchy hrchy) {
        Response response = new Response();
        Hrchy hrchy1 =  hrchyRepository.save(hrchy);
        response.setSuccess(true);
        response.setData(hrchy1);
        return response;
    }

    public Hrchy DeleteById(int id) {
        Hrchy hrchy = hrchyRepository.findById(id).get();
        hrchyRepository.delete(hrchy);
        return hrchy;
    }
}
