package com.todo.user.entity;

import com.todo.utils.AbstractEntity;
import com.todo.validator.unique.UniqueKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity(name = "usr")
@Getter @Setter @ToString
/*@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {
        "username", "email"}) })*/
/*@UniqueKey(columnNames={"username"})*/
public class User extends AbstractEntity {

    @NotNull
    @NotBlank(message = "Please enter username")
    @Column(name = "username", unique = true)
    @Size(min = 4, max = 10, message = "Min 4 and Max 10 characters allowed")
    private String username;

    @NotNull
    @NotBlank(message = "Please enter password")
    @Column(name = "password")
    private String password;

    @Email(message = "{user.email.invalid}")
    @NotNull
    @NotBlank(message = "Please enter email")
    @Column(name = "email", unique = true)
    private String email;

    @Size(min = 4, max = 14, message = "Min 4 and Max 14 digits allowed")
    @Pattern(regexp=("^\\d{10}$"), message = "Please enter valid phone no.")
    @Column(name = "phone")
    private String phone;

    @NotNull
    @NotBlank(message = "Please enter Full Name")
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;
}
