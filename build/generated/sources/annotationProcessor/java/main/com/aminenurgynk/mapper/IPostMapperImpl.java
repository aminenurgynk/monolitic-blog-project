package com.aminenurgynk.mapper;

import com.aminenurgynk.dto.response.PostResponseDto;
import com.aminenurgynk.repository.entity.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-15T23:59:13+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 20 (Oracle Corporation)"
)
@Component
public class IPostMapperImpl implements IPostMapper {

    @Override
    public List<PostResponseDto> toPostResponseDtos(List<Post> postList) {
        if ( postList == null ) {
            return null;
        }

        List<PostResponseDto> list = new ArrayList<PostResponseDto>( postList.size() );
        for ( Post post : postList ) {
            list.add( postResponseDto( post ) );
        }

        return list;
    }

    @Override
    public PostResponseDto postResponseDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponseDto.PostResponseDtoBuilder postResponseDto = PostResponseDto.builder();

        postResponseDto.title( post.getTitle() );
        postResponseDto.content( post.getContent() );

        return postResponseDto.build();
    }
}
