package controle_financeiro.controle_financeiro.repository;

import controle_financeiro.controle_financeiro.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    Usuario Nome(String nome);
    Usuario Email(String email);
    Usuario Telefone(String telefone);
    Usuario Idade(Integer idade);
    Usuario Endereco(String endereco);
    Usuario Profissao(String profissao);
    Usuario Salario(Double salario);
    Usuario Senha(String senha);
    Optional<Usuario> findById(Integer id);
    
}
