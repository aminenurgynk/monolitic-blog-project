package com.aminenurgynk.mapper;

import com.aminenurgynk.dto.response.CategoryResponseDto;
import com.aminenurgynk.repository.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-15T23:41:42+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 20 (Oracle Corporation)"
)
@Component
public class ICategoryMapperImpl implements ICategoryMapper {

    @Override
    public List<CategoryResponseDto> toCategoryResponseDtos(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryResponseDto> list = new ArrayList<CategoryResponseDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( categoryToCategoryResponseDto( category ) );
        }

        return list;
    }

    protected CategoryResponseDto categoryToCategoryResponseDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponseDto.CategoryResponseDtoBuilder categoryResponseDto = CategoryResponseDto.builder();

        categoryResponseDto.name( category.getName() );

        return categoryResponseDto.build();
    }
}
