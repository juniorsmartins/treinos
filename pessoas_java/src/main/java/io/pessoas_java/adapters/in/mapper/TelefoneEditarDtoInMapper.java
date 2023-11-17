package io.pessoas_java.adapters.in.mapper;

import io.pessoas_java.adapters.in.dto.request.TelefoneEditarDtoIn;
import io.pessoas_java.application.core.domain.value_object.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneEditarDtoInMapper {

    Telefone toTelefone(TelefoneEditarDtoIn telefoneEditarDtoIn);
}

