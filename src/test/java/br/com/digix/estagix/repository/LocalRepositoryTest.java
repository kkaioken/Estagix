package br.com.digix.estagix.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LocalRepositoryTest {
	@Autowired
	LocalRepository localRepository;

	@Test 
	void deve_buscar_todos_os_locais() {
		int quantidadeEsperada = 2;
		Local local1 = new Local("desenvolvimento");
		localRepository.save(local1);
		Local local2 = new Local("auditório");
		localRepository.save(local2);
    
		Collection<Local> locaisRetornados = localRepository.findAll();

		assertEquals(quantidadeEsperada,locaisRetornados.size());
		assertTrue(locaisRetornados.contains(local1));
		assertTrue(locaisRetornados.contains(local2));
	}
}
