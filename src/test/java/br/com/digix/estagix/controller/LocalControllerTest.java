package br.com.digix.estagix.controller;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.model.Local;
import br.com.digix.estagix.repository.LocalRepository;
import br.com.digix.estagix.service.LocalService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LocalControllerTest {
    @Autowired 
    private LocalRepository localRepository;

    @Autowired
    private LocalService localService;

    @Test
    void deve_buscar_um_local_cadastro(){
       int quantidadeAguardada = 2;
       Local local1 =  new Local("Desenvolvimento");
       Local local2 = new Local("Espaço Conexão");

       localRepository.save(local1);
       localRepository.save(local2);

       Collection<LocalResponseDTO> locais = localService.buscarTodos();

       
       assertEquals(quantidadeAguardada, locais.size());
        assertThat(locais).extracting("id").contains(local1.getId());
        assertThat(locais).extracting("id").contains(local2.getId());
    }
}
