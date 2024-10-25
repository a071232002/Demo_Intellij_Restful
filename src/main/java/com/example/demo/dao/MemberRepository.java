package com.example.demo.dao;

import com.example.demo.data.po.MemberPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberPO, Long>, JpaSpecificationExecutor {

    List<MemberPO> findAllByAge (Integer age);
}
