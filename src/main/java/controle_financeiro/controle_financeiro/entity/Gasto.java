package controle_financeiro.controle_financeiro.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "gastos", schema = "controle_financeiro")
public class Gasto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double valor;

    private LocalDate data;

    private Boolean recorrente;
    
    @ManyToOne
    @JoinColumn(name = "area_controle_id", nullable = false)
    private AreaControle areaControle;

    //Getters e Setters

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public Boolean getRecorrente (){
        return recorrente;
    }

    public void setRecorrente(Boolean recorrente){
        this.recorrente = recorrente;
    }

    public AreaControle getAreaControle(){
        return areaControle;
    }

    public void setAreaControle(AreaControle areaControle){
        this.areaControle = areaControle;
    
    }
}
