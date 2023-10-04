package com.aminenurgynk.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequestDto {

    private String title;
    private String content;
    private Long user_id;
    private Long category_id;
}
