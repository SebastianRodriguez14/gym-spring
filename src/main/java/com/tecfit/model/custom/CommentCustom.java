package com.tecfit.model.custom;

import com.tecfit.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentCustom {
    private Integer Id_comment;
    private String Content;
    private User user;

}
