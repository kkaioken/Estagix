package br.com.digix.estagix.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.model.Local;
import br.com.digix.estagix.repository.LocalRepository;

@SpringBootTest
public class LocalServiceTest {
    @Autowired
    private LocalRepository localRepository;
    
    @Autowired
    private LocalService localService;

    @BeforeEach
    void setUp() {
        localRepository.deleteAll();
    }

    @Test
    void deve_buscar_um_local() {
        int quantidadeEsperada = 2;
        Local local1 = new Local("auditorio");
        Local local2 = new Local("desenvolvimento");
        localRepository.save(local1);
        localRepository.save(local2);

        Collection<LocalResponseDTO> locais = localService.buscarTodos();
        
        assertEquals(quantidadeEsperada, locais.size());
        assertThat(locais).extracting("nome").contains(local1.getNome());
        assertThat(locais).extracting("nome").contains(local2.getNome());
        assertThat(locais).extracting("id").contains(local1.getId());
        assertThat(locais).extracting("id").contains(local2.getId());
    }
}
