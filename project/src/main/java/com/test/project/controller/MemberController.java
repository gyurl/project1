package com.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.form.MemberForm;
import com.test.project.repository.MemberRepository;
import com.test.project.service.MemberService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody MemberForm memberForm) {
      log.info("Register request received: {}", memberForm);
      try {
            memberService.register(memberForm);
            log.info("회원가입 성공: {}", memberForm.getName());  // 성공 로그 남기기
            return ResponseEntity.ok("Registration successful");

        } catch (IllegalArgumentException e) {
            log.warn("회원가입 실패: {}", e.getMessage());  // 경고 로그 남기기
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {
            log.error("회원가입 실패: {}", e.getMessage(), e);  // 에러 로그 남기기
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
        } 
    }
    
}
