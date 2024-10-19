package clube.selva.Api.controller;

import clube.selva.Api.socio.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroSocio dados){
       // System.out.println(dados);
       repository.save(new Socio(dados));
    }
    @GetMapping
    public Page<DadosListagemSocios> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginas){
        return repository.findAll(paginas).map(DadosListagemSocios::new);
    }
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoSocio dados){
        var socio = repository.getReferenceById(dados.id());
        socio.atualizarInformacoesSocio(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var socio = repository.getReferenceById(id);
        repository.delete(socio);
    }
}
