package controle_financeiro.controle_financeiro.controller;

import controle_financeiro.controle_financeiro.entity.Gasto;
import controle_financeiro.controle_financeiro.service.GastoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {
    
    @Autowired
    private final GastoService gastoService;

    public GastoController(GastoService gastoService){

        this.gastoService = gastoService;

    }

    @PostMapping
    public ResponseEntity<Gasto> criar(@RequestBody Gasto gasto){

        return ResponseEntity.ok(gastoService.criarGasto(gasto));

    }

    @GetMapping
    public ResponseEntity<List<Gasto>> listar() {

        return ResponseEntity.ok(gastoService.listarGastos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Gasto> buscarPorId(@PathVariable Long id){

        Optional<Gasto> gasto = gastoService.buscarGastoPorId(id);
        return gasto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        gastoService.deletarGasto(id);
        return ResponseEntity.noContent().build();

    }
}
