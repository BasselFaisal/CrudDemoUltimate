package com.crud.demo.service;

import com.crud.demo.Constants;
import com.crud.demo.model.hrchy.Hrchy;
import com.crud.demo.model.response.Response;
import com.crud.demo.model.user.User;
import com.crud.demo.repository.HrchyRepository;
import com.crud.demo.repository.UserRepository;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HrchyRepository hrchyRepository;

    public List<User> findAll() {

        List<User> users = userRepository.findAll();

        return users;
    }

    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        }else{
            return new User();
        }
    }

    public boolean checkIfExistByCode(String userCode) {
        return userRepository.existsByUserCode(userCode);
    }

    public Response saveUser(User user) {

        Response response = new Response();

        try {

           Optional<Hrchy> hrchy = hrchyRepository.findById(user.getHrchy().getId());

           if(hrchy.isPresent()) {
               user.setHrchy(hrchy.get());
               userRepository.save(user);

               response.setSuccess(true);
               response.setData(user);
           }else{
               response.setSuccess(false);
               response.addErrorMsgToResponse(Constants.HRCHY_NOT_FOUND);
           }
        }catch(Exception e){
            response.setSuccess(false);
            response.addErrorMsgToResponse(e.getMessage());
        }
        return response;
    }
}
