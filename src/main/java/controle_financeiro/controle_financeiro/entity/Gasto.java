package controle_financeiro.controle_financeiro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



@Entity
@Getter
@Setter
public class Gasto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private LocalDate data;

    private Boolean recorrente;

    
    @ManyToOne
    @JoinColumn(name = "area_controle", nullable = false)
    private AreaControle areaControle;

}
