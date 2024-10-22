package clube.selva.Api.socio;

import clube.selva.Api.endereco.Endereco;

public record DadosDetalhamentoSocio(Long id, Boolean ativo, String nome, String email, String telefone, Categoria categoria, Endereco endereco) {

    public DadosDetalhamentoSocio(Socio socio) {
        this(socio.getId(), socio.isAtivo(), socio.getNome(), socio.getEmail(), socio.getTelefone(), socio.getCategoria(), socio.getEndereco());
    }
}
