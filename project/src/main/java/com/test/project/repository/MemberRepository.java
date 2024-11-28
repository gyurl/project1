package com.test.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.project.domain.Member;



public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByname(String name);
    boolean existsByemail(String email);
}

