package br.com.desafio.infrastructure.dto.response;

public record ValidationError(String field, String message) {
}