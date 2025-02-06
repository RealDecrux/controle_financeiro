package controle_financeiro.controle_financeiro.controller;

import controle_financeiro.controle_financeiro.entity.AreaControle;
import controle_financeiro.controle_financeiro.service.AreaControleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/areas-controle")
public class AreaControleController {
    
    @Autowired
    private final AreaControleService areaControleService;

    public AreaControleController(AreaControleService areaControleService){
        this.areaControleService = areaControleService;
    }

    @PostMapping
    public ResponseEntity<AreaControle> criarAreaControle(@RequestBody AreaControle areaControle) {
        
        AreaControle novaAreaControle = areaControleService.criarAreaControle(areaControle);
        return ResponseEntity.ok(novaAreaControle);

    }

    @GetMapping
    public ResponseEntity<List<AreaControle>> listar() {
        
        return ResponseEntity.ok(areaControleService.listarAreasControle());

    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaControle> buscarPorId(@PathVariable("id") Long id){


               
            Optional<AreaControle> area = areaControleService.buscarPorId(id);
            return area.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        
    }
    
    
}
