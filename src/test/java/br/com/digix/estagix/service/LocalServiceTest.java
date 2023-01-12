package br.com.digix.estagix.service;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.model.Local;
import br.com.digix.estagix.repository.LocalRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(locais.contains(local1));
        assertTrue(locais.contains(local2));
        assertEquals(quantidadeEsperada, locais.size());
    }
}
