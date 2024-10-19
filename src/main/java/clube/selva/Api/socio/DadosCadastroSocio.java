package clube.selva.Api.socio;

import clube.selva.Api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroSocio(

               @NotBlank
                String nome,
                @NotBlank
                String telefone,
                @NotBlank
                        @Email
                String email,
                @NotBlank @Pattern(regexp = "\\d{6}")
                String carteirinha,
                @NotNull
                Categoria categoria,
                @NotNull @Valid DadosEndereco endereco
) {
}
