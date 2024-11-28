package com.test.project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL AUTO
    @Column(name = "id")
    private Long id;

    @Column(name = "member_name", nullable = false)
    @NotBlank(message = "이름을 입력하세요")
    private String name;
    
    @Column(name = "member_email", nullable = false)
    @NotBlank(message = "이메일을 입력하세요")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;
}
