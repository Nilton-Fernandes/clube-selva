package clube.selva.Api.socio;

public record DadosListagemSocios(
        Long id,
        String nome,
        String telefone,
        String email,
        String carteirinha,
        Categoria categoria
) {
    public DadosListagemSocios(Socio socio) {
        this(socio.getId(), socio.getNome(), socio.getTelefone(), socio.getEmail(), socio.getCarteirinha(), socio.getCategoria());
    }
}
