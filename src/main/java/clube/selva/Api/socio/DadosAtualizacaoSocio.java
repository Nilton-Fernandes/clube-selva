package clube.selva.Api.socio;

import clube.selva.Api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoSocio(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
