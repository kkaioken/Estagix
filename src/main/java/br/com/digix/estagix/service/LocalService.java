package br.com.digix.estagix.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.mappers.LocalMapper;
import br.com.digix.estagix.model.Local;
import br.com.digix.estagix.repository.LocalRepository;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private LocalMapper localMapper;

    public Collection<LocalResponseDTO> buscarTodos(){
        Collection<Local> locais = (Collection<Local>) localRepository.findAll();
        return localMapper.locaisParaLocalResponse(locais);
    }
    
   
}
