package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.config.MailConfig;
import br.org.serratec.backend.dto.UsuarioDTO;
import br.org.serratec.backend.dto.UsuarioInserirDTO;
import br.org.serratec.backend.exception.EmailException;
import br.org.serratec.backend.model.Usuario;
import br.org.serratec.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	private MailConfig mailConfig;

	public List<UsuarioDTO> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();

		for (Usuario usuario : usuarios) {
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
			usuariosDTO.add(usuarioDTO);
		}

		return usuariosDTO;
	}

	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException {

		if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()) != null) {
			throw new EmailException("Email já existe ! Insira outro");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());

		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		usuarioRepository.save(usuario);
		mailConfig.enviarEmail(usuario.getEmail(), "Cadastro De Usuário Confirmado", usuario.toString());
		return new UsuarioDTO(usuario);

	}
	
	public UsuarioDTO editar(Long id, UsuarioDTO usuarioDTO) throws EmailException {

				
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		
		usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);

	}
	 
}
