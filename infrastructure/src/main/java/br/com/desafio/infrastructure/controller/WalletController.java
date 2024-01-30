package br.com.desafio.infrastructure.controller;

import br.com.desafio.infrastructure.dto.request.TransferRequest;
import br.com.desafio.infrastructure.dto.response.BaseResponse;
import br.com.desafio.infrastructure.dto.response.ConsultBalanceResponse;
import br.com.desafio.usecase.ConsultBalanceUseCase;
import br.com.desafio.usecase.TransferUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private final ConsultBalanceUseCase consultBalanceUseCase;
    private final TransferUseCase transferUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(TransferRequest request) throws Exception {
        transferUseCase.transfer(
                request.fromTaxNumber(),
                request.toTaxNumber(),
                request.value(),
                request.pin()
        );
        return BaseResponse.<String>builder().success(true).message("Transferencia realizada com sucesso").build();
    }
}
