package controle_financeiro.controle_financeiro.repository;

import controle_financeiro.controle_financeiro.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

    List<Gasto> areaControleId(Long areaControleId);
    
}
