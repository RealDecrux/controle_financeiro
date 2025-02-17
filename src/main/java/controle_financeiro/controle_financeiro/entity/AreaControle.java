package controle_financeiro.controle_financeiro.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "areas_controle", schema = "controle_financeiro")
public class AreaControle{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    private Double limiteGasto;

    
    @ManyToMany
    @JoinTable(
        name = "usuarios_areas_controle",
        joinColumns = {@JoinColumn(name = "area_controle_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn (name = "usuario_id", referencedColumnName = "id")}
    )
    private List<Usuario> usuario;

    //Getters e setters

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

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Double limiteGasto(){
        return limiteGasto;
    }

    public void setLimiteGasto(Double limiteGasto){
        this.limiteGasto = limiteGasto;
    }

    public List<Usuario> getUsuario(){
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario){
        this.usuario = usuario;
    }



    
}