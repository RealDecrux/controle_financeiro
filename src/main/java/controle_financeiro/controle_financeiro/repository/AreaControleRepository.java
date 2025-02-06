package controle_financeiro.controle_financeiro.repository;

import controle_financeiro.controle_financeiro.entity.AreaControle;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AreaControleRepository extends JpaRepository<AreaControle, Long>{

    AreaControle descricao(String descricao);
    Optional<AreaControle> findByLimiteGasto(Double LimiteGasto);
    AreaControle usuario_id(Integer id);
    Optional<AreaControle> Nome(String nome);
    
    
}
