package com.krotos.MoneyTransfer.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "USERS")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usrId;
    @NonNull
    private String name;
    @NonNull
    private String password;
    @NonNull
    private String role;
}
