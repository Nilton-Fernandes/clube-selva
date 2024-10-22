package clube.selva.Api.socio;

import clube.selva.Api.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroSocioService {
    @Autowired
    private SocioRepository repository;

    public DadosDetalhamentoSocio cadastrar(DadosCadastroSocio dados) {
        var jaCadastrado = repository.existsByEmailOrCarteirinha(dados.email(), dados.carteirinha());
        if (jaCadastrado) {
            throw new ValidacaoException("Já existe outro sócio cadastrado com o email ou carteirinha informado!");
        }

        var socio = new Socio(dados);
        repository.save(socio);
        return new DadosDetalhamentoSocio(socio);
    }
}
