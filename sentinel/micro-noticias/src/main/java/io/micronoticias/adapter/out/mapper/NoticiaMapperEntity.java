package io.micronoticias.adapter.out.mapper;

import io.micronoticias.adapter.out.entity.NoticiaEntity;
import io.micronoticias.application.core.domain.NoticiaBusiness;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoticiaMapperEntity {

    NoticiaEntity fromNoticiaBusiness(NoticiaBusiness noticiaBusiness);
}

