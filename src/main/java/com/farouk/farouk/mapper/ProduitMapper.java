package com.farouk.farouk.mapper;

import com.farouk.farouk.dao.ProduitsDto;
import com.farouk.farouk.model.Produits;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produits toEntity(ProduitsDto pdto);
    ProduitsDto toDTo(Produits p);
}
