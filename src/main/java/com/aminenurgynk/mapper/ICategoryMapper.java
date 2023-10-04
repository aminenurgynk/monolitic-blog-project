package com.aminenurgynk.mapper;

import com.aminenurgynk.dto.response.CategoryResponseDto;
import com.aminenurgynk.repository.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper {

    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);
    List<CategoryResponseDto> toCategoryResponseDtos(List<Category> categoryList);
}
