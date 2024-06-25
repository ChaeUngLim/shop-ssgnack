package com.ssgnack.admin.controller;

import com.ssgnack.admin.controller.dto.AdminFormDto;
import com.ssgnack.admin.model.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    /**
     * 로그인 페이지 이동
     */
    @GetMapping("/login")
    public String login(Model model){
        log.info("여기여기 login 페이지");

        AdminFormDto adminFormDto = new AdminFormDto();
        model.addAttribute("adminFormDto", adminFormDto);

        return "/admin/login";
    }

    /**
     * 로그인 시도
     */
    @PostMapping("/login")
    public String login(@ModelAttribute("adminFormDto") AdminFormDto adminFormDto,
                        HttpServletRequest request){

        log.info("로그인 시도~~");
        log.info("email : " + adminFormDto.getEmail());
        log.info("pw : " + adminFormDto.getPw());

        if(adminService.checkUser(adminFormDto)){
            int userId = adminService.login(adminFormDto.getEmail());
            HttpSession session = request.getSession(true);

            session.setAttribute("userId", userId);

            log.info("로그인 성공~");
            return "redirect:/main";
        }

        log.info("로그인 실패~");
        return "/admin/login";
    }

    /**
     * 회원가입 페이지 이동
     */
    @GetMapping("/signup")
    public String signup(){
        log.info("여기여기 signup 페이지");
        return "/admin/signup";
    }


    /**
     * 회원가입 시도
     */
    @PostMapping("/signup")
    public String signup(@ModelAttribute("adminFormDto") AdminFormDto adminFormDto){
        log.info("회원가입 시도~~");
        log.info("email : " + adminFormDto.getEmail());
        log.info("pw : " + adminFormDto.getPw());

        if(adminService.checkEmail(adminFormDto.getEmail())){
            adminService.signup(adminFormDto);

            log.info("회원가입 성공~");
            return "redirect:/admin/login";
        }

        log.info("회원가입 실패~");
        return "/admin/signup";
    }
}
