package com.devrodrigosnr.ct_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devrodrigosnr.ct_management.dto.AlunoDTO;
import com.devrodrigosnr.ct_management.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<AlunoDTO> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public AlunoDTO salvarAluno(@RequestBody AlunoDTO aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping("/{id}")
    public AlunoDTO findById(@PathVariable Long id) {
        return alunoService.buscarAlunoPorID(id);
    }

    @GetMapping("/aniversariantes")
    public List<AlunoDTO> getAniversariantes() {
        return alunoService.listarAlunos();
    }

}
