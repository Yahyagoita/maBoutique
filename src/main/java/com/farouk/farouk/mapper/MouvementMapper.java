package com.farouk.farouk.mapper;

import com.farouk.farouk.dao.MouvementDto;
import com.farouk.farouk.model.Mouvement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MouvementMapper {
    Mouvement toEntity(MouvementDto dto);
    MouvementDto toDTo(Mouvement mouvement);
}
