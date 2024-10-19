package clube.selva.Api.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(

        @NotBlank
        String logradouro,
        String numero,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf)
{
}

