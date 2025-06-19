package com.devrodrigosnr.ct_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devrodrigosnr.ct_management.dto.AlunoDTO;
import com.devrodrigosnr.ct_management.mapper.AlunoMapper;
import com.devrodrigosnr.ct_management.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository repository, AlunoMapper alunoMapper) {
        this.repository = repository;
        this.alunoMapper = alunoMapper;
    }

    public List<AlunoDTO> listarAlunos() {
        return repository.findAll()
            .stream()
            .map(alunoMapper::toDTO)
            .toList();
    }

    public AlunoDTO salvarAluno(AlunoDTO aluno) {
        return alunoMapper.toDTO(repository.save(alunoMapper.toEntity(aluno)));
    }

    public AlunoDTO buscarAlunoPorID(Long id) {
        return repository.findById(id).map(alunoMapper::toDTO)
            .orElseThrow(() -> null);
    }

}
