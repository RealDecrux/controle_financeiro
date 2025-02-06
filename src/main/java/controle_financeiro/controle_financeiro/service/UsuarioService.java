package controle_financeiro.controle_financeiro.service;

import controle_financeiro.controle_financeiro.entity.Usuario;
import controle_financeiro.controle_financeiro.repository.UsuarioRepository;
import lombok.Data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Data
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        
        return usuarioRepository.save(usuario);

    }

    public Optional<Usuario> buscarUsuario(Long id){

        return usuarioRepository.findById(id);

    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
            .map(usuario -> atualizarDadosUsuario(usuario, usuarioAtualizado))
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }
    
    private Usuario atualizarDadosUsuario(Usuario usuarioExistente, Usuario usuarioAtualizado) {
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSalario(usuarioAtualizado.getSalario());
        return usuarioRepository.save(usuarioExistente);
    }
    

}
