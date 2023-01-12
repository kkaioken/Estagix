package br.com.digix.estagix.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LocalTest {
    @Test
        void deve_acessar_um_local(){
            String nome = "flavin";
            Local local = new Local(nome);
            assertEquals(nome, local.getNome());
        }
}
   