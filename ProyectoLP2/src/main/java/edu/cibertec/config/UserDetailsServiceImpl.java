package edu.cibertec.config;

import edu.cibertec.models.Usuario;
import edu.cibertec.repositories.UsuarioRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<Usuario> existusuario = usuarioRepository.findByUsername(username);
		
		if (existusuario.isEmpty()) {
			
			throw new UsernameNotFoundException("Error en el login: no existe el usuario"+ username);
		}
		Usuario usuario = existusuario.orElseThrow();		
		List<GrantedAuthority> authorities = Arrays.asList(usuario.getRole())
				.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))				
				.collect(Collectors.toList())
				;
		return new User(
				usuario.getUsername(),
				usuario.getPassword(),
				authorities);

    }
}
