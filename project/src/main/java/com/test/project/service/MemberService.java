package com.test.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.project.form.MemberForm;
import com.test.project.repository.MemberRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void register(MemberForm memberForm) {
        System.out.println("Register method called");
    }
}