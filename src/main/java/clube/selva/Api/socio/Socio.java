package clube.selva.Api.socio;


import clube.selva.Api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "socios")
@Entity(name = "Socio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Socio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String carteirinha;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Embedded
    private Endereco endereco;

    public Socio(DadosCadastroSocio dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.carteirinha = dados.carteirinha();
        this.categoria = dados.categoria();
       this.endereco = new Endereco(dados.endereco());
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCarteirinha() {
        return carteirinha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void atualizarInformacoesSocio(DadosAtualizacaoSocio dados) {
        if (dados.nome()!= null){
            this.nome = dados.nome();
        }
        if (dados.telefone()!= null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco()!= null){
            this.endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }


}
