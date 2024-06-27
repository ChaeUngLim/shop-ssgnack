package com.ssgnack.admin.model.dao;

import com.ssgnack.admin.controller.dto.AdminFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

    int checkAdmin(AdminFormDto adminFormDto);

    int login(@Param("email") String email);

    void signup(AdminFormDto adminFormDto);
    int checkEmail(@Param("email") String email);

}
