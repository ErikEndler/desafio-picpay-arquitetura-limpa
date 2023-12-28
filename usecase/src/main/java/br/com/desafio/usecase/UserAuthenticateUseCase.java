package br.com.desafio.usecase;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password);
}
