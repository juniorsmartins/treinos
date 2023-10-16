package io.pessoas_java.adapters.in.controller;

import io.pessoas_java.adapters.in.dto.request.PessoaDtoFiltro;
import io.pessoas_java.adapters.in.dto.request.PessoaDtoIn;
import io.pessoas_java.adapters.in.dto.request.PessoaEditarDtoIn;
import io.pessoas_java.adapters.in.dto.response.PessoaDtoOut;
import io.pessoas_java.adapters.in.mapper.PessoaDtoInMapper;
import io.pessoas_java.adapters.in.mapper.PessoaDtoOutMapper;
import io.pessoas_java.application.ports.in.PessoaCadastrarInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaCadastrarInputPort pessoaCadastrarInputPort;

    @Autowired
    private PessoaDtoInMapper pessoaDtoInMapper;

    @Autowired
    private PessoaDtoOutMapper pessoaDtoOutMapper;

    @PostMapping
    public ResponseEntity<PessoaDtoOut> cadastrar(@RequestBody @Valid PessoaDtoIn dtoIn) {

        var dtoOut = Optional.of(dtoIn)
                .map(this.pessoaDtoInMapper::toPessoa)
                .map(this.pessoaCadastrarInputPort::cadastrar)
                .map(this.pessoaDtoOutMapper::toPessoaDtoOut)
                .orElseThrow();

        return ResponseEntity
            .created(URI.create("/api/v1/pessoas/" + 1))
            .body(dtoOut);
    }

    @GetMapping
    public ResponseEntity<Page<PessoaDtoOut>> pesquisar(@Valid final PessoaDtoFiltro dtoFiltro,
        @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 10)
        final Pageable paginacao) {


        return ResponseEntity
            .ok()
            .body(null);
    }

    @PutMapping(path = "/{chave}")
    public ResponseEntity<PessoaDtoOut> editar(@PathVariable(name = "chave") final UUID chave,
                                               @RequestBody @Valid PessoaEditarDtoIn dtoIn) {


        return ResponseEntity
            .ok()
            .body(null);
    }

    @DeleteMapping(path = "/{chave}")
    public ResponseEntity<Void> deletar(@PathVariable(name = "chave") final UUID chave) {


        return ResponseEntity
            .noContent()
            .build();
    }
}

