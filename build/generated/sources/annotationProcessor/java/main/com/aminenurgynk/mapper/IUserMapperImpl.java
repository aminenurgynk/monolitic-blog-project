package com.aminenurgynk.mapper;

import com.aminenurgynk.dto.request.RegisterRequestDto;
import com.aminenurgynk.dto.response.UserResponseDto;
import com.aminenurgynk.repository.entity.User;
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
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserResponseDto toUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.id( user.getId() );
        userResponseDto.firstName( user.getFirstName() );
        userResponseDto.lastName( user.getLastName() );
        userResponseDto.email( user.getEmail() );

        return userResponseDto.build();
    }

    @Override
    public User toUser(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( dto.getFirstName() );
        user.lastName( dto.getLastName() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public List<UserResponseDto> toUserResponseDtos(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserResponseDto( user ) );
        }

        return list;
    }
}
