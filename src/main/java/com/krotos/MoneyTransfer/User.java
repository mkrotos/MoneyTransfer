package com.krotos.MoneyTransfer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String password;
    @NonNull
    private String role;
}
