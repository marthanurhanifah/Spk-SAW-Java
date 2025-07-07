package com.example.spk.services;

import com.example.spk.model.Users;
import com.example.spk.payload.request.LoginRequest;
import com.example.spk.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class UsersServices {
    private static final Logger log = LoggerFactory.getLogger(Users.class);

    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<String> register(LoginRequest loginRequest){
        Users users = usersRepository.selectByUsername(loginRequest.getUsername());
        if (users != null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Username "+ loginRequest.getUsername()+" Sudah Digunkan");
        }

        Users users1 = new Users();
        users1.setUsername(loginRequest.getUsername());
        users1.setPassword(loginRequest.getPassword());
        users1.setCreatedDate(new Date());
        users1.setCreatedBy("System");
        users1.setUpdatedDate(new Date());
        users1.setUpdatedBy("System");
        Users usersResult = usersRepository.save(users1);
        return ResponseEntity.status(HttpStatus.OK).body("Register Sukses untuk username : "+ usersResult.getUsername());
    }

    public ResponseEntity<String> login(LoginRequest loginRequest){
        Integer cekUsernm = usersRepository.cariUsernameDgnCaseWhen(loginRequest.getUsername());
        if (cekUsernm == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username Tidak Ditemukan");
        }

        Integer cekUserPass = usersRepository.ceriUsernamePassword(loginRequest.getUsername(), loginRequest.getPassword());
        if(cekUserPass == 0){
            return ResponseEntity.status((HttpStatus.NOT_ACCEPTABLE)).body("Password Tidak Sesuai");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Login Berhasil untuk username : "+ loginRequest.getUsername());
    }
}
