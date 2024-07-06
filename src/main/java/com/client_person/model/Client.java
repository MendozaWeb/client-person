package com.client_person.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@DiscriminatorValue("Client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends Person {

    @Column(unique = true)
    private String clientId;
    private String password;
    private boolean status;
}

