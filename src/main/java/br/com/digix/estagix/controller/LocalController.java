package br.com.digix.estagix.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.estagix.dto.LocalResponseDTO;
import br.com.digix.estagix.repository.LocalRepository;
import br.com.digix.estagix.service.LocalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = {"/api/v1/locais"}, produces = { "application/json"})

public class LocalController {
    @Autowired
    private LocalService localService;

    @Autowired
    private LocalRepository localRepository;

    @Operation(summary = "Buscar todos os locais cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de locais cadastrados")
    @GetMapping
    public ResponseEntity<Collection<LocalResponseDTO>> buscarTodos(
        @RequestParam(required = false, name = "termo") String nome) {
      return ResponseEntity.ok(localService.buscarTodos());
    }
}
