package com.todo.task.entity;

import com.todo.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
    @NotEmpty
    private Time time;

    @NotNull
    @NotEmpty
    private Date date;

    @NotNull
    @NotEmpty
    private String taskName;

    private String description;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER)
    private List<Comment> comments = new LinkedList<>();
}
