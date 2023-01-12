package br.com.digix.estagix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.BeforeEach;

import br.com.digix.estagix.dto.LocalRequestDTO;
import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.model.Local;

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

        AssertTrue(locais.contains(local1));
        AssertTrue(locais.contains(local2));
        assertEquals(quantidadeEsperada, locais.size());
    }
}
