package controle_financeiro.controle_financeiro.repository;

import controle_financeiro.controle_financeiro.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;


public interface GastoRepository extends JpaRepository<Gasto, Long> {

    Gasto id(Long id);
    Gasto descricao(String descricao);
    Gasto valor(LocalDate data);
    Gasto recorrente(Boolean recorrente);
    List<Gasto> areaControleId(Long areaControleId);
    
}
