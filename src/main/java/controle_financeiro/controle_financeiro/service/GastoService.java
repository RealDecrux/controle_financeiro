package controle_financeiro.controle_financeiro.service;


import controle_financeiro.controle_financeiro.entity.Gasto;
import controle_financeiro.controle_financeiro.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoService {
    
    private final GastoRepository gastoRepository;

    public GastoService(GastoRepository gastoRepository){
        this.gastoRepository = gastoRepository;
    }

    public Gasto criarGasto(Gasto gasto){
        return gastoRepository.save(gasto);
    }

    public List<Gasto> listarGastos() {
        return gastoRepository.findAll();
    }

    public void deletarGasto(Long id){
        gastoRepository.deleteById(id);
    }

    public Optional<Gasto> buscarGastoPorId(Long id){
        return gastoRepository.findById(id);
    }

}
