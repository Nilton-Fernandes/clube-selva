package clube.selva.Api.controller;

import clube.selva.Api.socio.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioRepository repository;

    @Autowired
    private CadastroSocioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoSocio> cadastrar(@RequestBody @Valid DadosCadastroSocio dados, UriComponentsBuilder uriBuilder){
        var detalhesSocio = service.cadastrar(dados);
        var uri = uriBuilder.path("/socios/{id}").buildAndExpand(detalhesSocio.id()).toUri();
        return ResponseEntity.created(uri).body(detalhesSocio);
    }


    @GetMapping
    public Page<DadosListagemSocios> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginas){
        return repository.findAll(paginas).map(DadosListagemSocios::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoSocio> atualizar(@RequestBody @Valid DadosAtualizacaoSocio dados){
        var socio = repository.getReferenceById(dados.id());
        socio.atualizarInformacoesSocio(dados);
        repository.save(socio);
        return ResponseEntity.ok(new DadosDetalhamentoSocio(socio));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var socio = repository.getReferenceById(id);
        repository.delete(socio);
    }
}
