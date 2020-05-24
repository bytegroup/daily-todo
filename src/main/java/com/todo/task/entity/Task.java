package com.todo.task.entity;

import com.todo.user.entity.User;
import com.todo.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Task extends AbstractEntity{

    @NotNull
    @Column(name = "time")
    private Time time;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @NotEmpty
    @Column(name = "taskname")
    private String taskName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User taskOwner;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER)
    private List<Comment> comments = new LinkedList<>();
}
