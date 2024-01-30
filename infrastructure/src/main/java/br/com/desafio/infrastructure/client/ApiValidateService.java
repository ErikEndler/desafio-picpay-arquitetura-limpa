package br.com.desafio.infrastructure.client;

import br.com.desafio.infrastructure.client.dto.response.ApiValidateResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiValidateService {
    private final ApiValidationClient apiValidationClient;

    public ApiValidateService(ApiValidationClient apiValidationClient) {
        this.apiValidationClient = apiValidationClient;
    }

    public Optional<ApiValidateResponse> validate() {
        try {
            return Optional.ofNullable(apiValidationClient.validate());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
