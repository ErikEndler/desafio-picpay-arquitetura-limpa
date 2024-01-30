package br.com.desafio.infrastructure.client;

import br.com.desafio.infrastructure.client.dto.response.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidateClient", url = "${client.url}")
public interface ApiValidationClient {
    @GetMapping
    ApiValidateResponse validate();
}
