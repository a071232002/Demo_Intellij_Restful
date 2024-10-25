package com.example.demo.data.po;

import com.example.demo.data.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class MemberPO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1906147353389912680L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;

    private String firstName;

    private String lastName;

    private Integer age;

    private Float height;


}
