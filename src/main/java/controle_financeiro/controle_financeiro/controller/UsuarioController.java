package controle_financeiro.controle_financeiro.controller;

import controle_financeiro.controle_financeiro.entity.Usuario;
import controle_financeiro.controle_financeiro.service.UsuarioService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

        @Autowired
        private UsuarioService usuarioService;

        @PostMapping
        public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){

            Usuario novoUsuario = usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);

        }

        @GetMapping("/{id}")
        public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id){
            Optional<Usuario> usuario = usuarioService.buscarUsuario(id);
            return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        }
        

        @PutMapping("/{id}")
        public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioAtualizado) {
            
            try{
                Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
                return ResponseEntity.ok(usuario);
            } catch (RuntimeException e){
                return ResponseEntity.notFound().build();
            }
            
        }

}