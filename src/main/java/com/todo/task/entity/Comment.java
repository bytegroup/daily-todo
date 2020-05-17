package com.todo.task.entity;

import com.todo.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @ToString
public class Comment extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String comment;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
