package com.example.demo.service;

import com.example.demo.dao.MemberRepository;
import com.example.demo.data.dto.MemberDTO;
import com.example.demo.data.po.MemberPO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;

    //create
    public MemberDTO create(MemberDTO memberDTO) {
        return toDTO(memberRepository.save(toPO(memberDTO)));
    }

    //read
    public MemberDTO readByUuid(Long uuid) {
        return memberRepository
                .findById(uuid)
                .map(this::toDTO)
                .orElseThrow(RuntimeException::new);
    }

    public List<MemberDTO> readAllByAge(Integer age) {
        return memberRepository
                .findAllByAge(age)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //update
    public MemberDTO updateHeightByUuid(Long uuid, Float height) {
        MemberPO memberPO = memberRepository.findById(uuid).orElseThrow(RuntimeException::new);
        memberPO.setHeight(height);
        return toDTO(memberRepository.save(memberPO));
    }

    //delete
    public void deleteByUuid(Long uuid) {
        memberRepository.deleteById(uuid);
    }

    private MemberPO toPO(MemberDTO memberDTO) {
        return MemberPO
                .builder()
                .firstName(memberDTO.getName().split(",")[0].trim())
                .lastName(memberDTO.getName().split(",")[1].trim())
                .age(memberDTO.getAge())
                .height(memberDTO.getHeight())
                .build();
    }

    private MemberDTO toDTO(MemberPO memberPO) {
        return MemberDTO
                .builder()
                .uuid(memberPO.getUuid())
                .name(memberPO.getFirstName() + "," + memberPO.getLastName())
                .age(memberPO.getAge())
                .height(memberPO.getHeight())
                .build();
    }
}
