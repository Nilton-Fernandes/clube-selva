package clube.selva.Api.controller;

import clube.selva.Api.socio.DadosCadastroSocio;
import clube.selva.Api.socio.Socio;
import clube.selva.Api.socio.SocioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
