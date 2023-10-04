package com.aminenurgynk.mapper;

import com.aminenurgynk.dto.response.PostResponseDto;
import com.aminenurgynk.repository.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPostMapper {

    IPostMapper INSTANCE = Mappers.getMapper(IPostMapper.class);
    List<PostResponseDto> toPostResponseDtos(List<Post> postList);
    PostResponseDto postResponseDto (Post post);
}
