package io.pessoas_java.adapters.in.mapper;

import io.pessoas_java.adapters.in.dto.request.PessoaEditarDtoIn;
import io.pessoas_java.application.core.domain.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaEditarDtoInMapper {

    @Mapping(source = "usuario.username", target = "usuario.username")
    @Mapping(source = "usuario.password", target = "usuario.password")
    Pessoa toPessoa(PessoaEditarDtoIn editarDtoIn);
}

