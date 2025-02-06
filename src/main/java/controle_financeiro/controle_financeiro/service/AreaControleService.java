package controle_financeiro.controle_financeiro.service;

import controle_financeiro.controle_financeiro.entity.AreaControle;
import controle_financeiro.controle_financeiro.repository.AreaControleRepository;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class AreaControleService {
    
    @Autowired
    private final AreaControleRepository areaControleRepository;
    
    public AreaControleService(AreaControleRepository areaControleRepository){
        this.areaControleRepository = areaControleRepository;
    }

    public AreaControle criarAreaControle(AreaControle areaControle){
        return areaControleRepository.save(areaControle);
    }

    public List<AreaControle> listarAreasControle(){
        return areaControleRepository.findAll();
    }

    public Optional<AreaControle> buscarPorId(Long id){
        return areaControleRepository.findById(id);
    }

}
