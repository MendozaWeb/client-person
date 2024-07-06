package com.client_person.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateClientRequestDto {
    private String clientId;
    private String password;
    private boolean status;
}
