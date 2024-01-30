package br.com.desafio.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String userName, String password);
}
