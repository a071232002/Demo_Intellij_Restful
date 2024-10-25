package com.example.demo;

import com.example.demo.data.dto.MemberDTO;
import com.example.demo.service.MemberService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<MemberDTO> create(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.create(memberDTO));
    }

    @GetMapping("/members/{uuid}")
    public ResponseEntity<MemberDTO> readByUuid(@PathVariable Long uuid) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.readByUuid(uuid));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> readAllByAge(@RequestParam Integer age) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.readAllByAge(age));
    }

    @PatchMapping("/members")
    public ResponseEntity<MemberDTO> updateHeightByUuid(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.updateHeightByUuid(memberDTO.getUuid(), memberDTO.getHeight()));
    }

    @DeleteMapping("/members/{uuid}")
    public ResponseEntity<Void> deleteByUuid(@PathVariable Long uuid) {
        memberService.deleteByUuid(uuid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
