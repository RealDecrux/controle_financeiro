package controle_financeiro.controle_financeiro.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios", schema = "controle_financeiro")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String email;

    private String nome;
    private String telefone;

    private Integer idade;
    private String endereco;
    private String profissao;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private String senha;

    @ManyToMany(mappedBy = "usuario")
    private List<AreaControle> areaControle; 

    // Getters e setters

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Integer getIdade(){
        return idade;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getProfissao(){
        return profissao;
    }

    public void setProfissao(String profissao){
        this.profissao = profissao;
    }

    public Double getSalario(){
        return salario;
    }

    public void setSalario(Double salario){
        this.salario = salario;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public List<AreaControle> getAreaControle(){
        return areaControle;
    }

    public void setAreaControle(List<AreaControle> areaControle){
        this.areaControle = areaControle;
    }
}
