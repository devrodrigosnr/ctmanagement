package com.devrodrigosnr.ct_management.mapper;

import org.springframework.stereotype.Component;

import com.devrodrigosnr.ct_management.dto.AlunoDTO;
import com.devrodrigosnr.ct_management.model.Aluno;

@Component
public class AlunoMapper {

    public AlunoDTO toDTO(Aluno aluno) {
        if(aluno == null) {
            return null;
        }
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getTelefone());
    }

    public Aluno toEntity(AlunoDTO alunoDTO) {
        if(alunoDTO == null) {
            return null;
        }

        Aluno aluno = new Aluno();
        if(alunoDTO.id() != null) {
            aluno.setId(alunoDTO.id());
        }

        aluno.setNome(alunoDTO.nome());
        aluno.setCpf(alunoDTO.cpf());
        aluno.setTelefone(alunoDTO.telefone());
        return aluno;
    } 
}
