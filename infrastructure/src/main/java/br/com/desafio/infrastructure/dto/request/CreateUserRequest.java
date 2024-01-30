package br.com.desafio.infrastructure.dto.request;

import br.com.desafio.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type, String pin) {
}
