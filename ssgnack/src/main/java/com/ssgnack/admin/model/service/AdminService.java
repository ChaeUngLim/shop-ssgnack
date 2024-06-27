package com.ssgnack.admin.model.service;


import com.ssgnack.admin.controller.dto.AdminFormDto;
import com.ssgnack.admin.model.dao.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;

    /**
     * 유저 확인
     */
    public boolean checkUser(AdminFormDto adminFormDto){

        int checkUser = adminMapper.checkAdmin(adminFormDto);

        if(checkUser == 1) return true;

        return false;
    }
    /**
     * 로그인
     */
    public int login(String email){
        return adminMapper.login(email);

    }

    /**
     * 회원가입
     */
    public void signup(AdminFormDto adminFormDto) {
        adminMapper.signup(adminFormDto);
    }

    /**
     * email 중복체크
     */
    public boolean checkEmail(String email){
        int checkEmail = adminMapper.checkEmail(email);

        if(checkEmail >= 1) return false;

        return true;
    }
}
