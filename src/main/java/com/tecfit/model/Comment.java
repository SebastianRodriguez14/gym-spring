package com.tecfit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer Id_comment;
    @Column(name = "Content")
    private  String Content;

    @ManyToOne
    @JoinColumn(name = "User")
    private User User;

    @ManyToOne
    @JoinColumn(name = "Routine")
    private Routine Routine;

    public Comment(Integer id_comment, String content, com.tecfit.model.User user) {
        Id_comment = id_comment;
        Content = content;
        User = user;
    }

}
