package br.com.projeto.integrado.service;


import br.com.projeto.integrado.entity.Projeto;
import br.com.projeto.integrado.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    ProjetoRepository projetoRepository;

    public List<Projeto> getAll(){
        return projetoRepository.findAll();
    }

    public Projeto getById(Integer id) {
        return projetoRepository.findById(id).orElse(null) ;
    }

    // Pegando projeto pela descrição
    public Projeto findByProjetoDescricao(String desc) {
        return projetoRepository.findByProjetoDescricao(desc).get();
    }

    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto updateProjeto(Integer id, Projeto projeto) {
        Projeto projetoAtualizado = projetoRepository.findById(id).orElse(null);
        if(projetoAtualizado != null) {
            projetoAtualizado.setGerentes(projeto.getGerentes());
            projetoAtualizado.setProjetoDescricao(projeto.getProjetoDescricao());
            projetoAtualizado.setProjetoFim(projeto.getProjetoFim());
            projetoAtualizado.setProjetoInicio(projeto.getProjetoInicio());
            projetoAtualizado.setProjetoNome(projeto.getProjetoNome());
            projetoAtualizado.setProjetoStatus(projeto.getProjetoStatus());
            return projetoRepository.save(projetoAtualizado);
        }else {
            return null;
        }
    }

    public Boolean deleteProjeto(Integer id) {
        Projeto projeto = projetoRepository.findById(id).orElse(null);
        if(projeto != null) {
            projetoRepository.delete(projeto);
            return true;
        }else {
            return false;
        }
    }
}