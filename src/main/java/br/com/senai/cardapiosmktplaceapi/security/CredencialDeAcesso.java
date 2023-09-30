package br.com.senai.cardapiosmktplaceapi.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.senai.cardapiosmktplaceapi.entity.Usuario;
import lombok.Data;

@Data
public class CredencialDeAcesso  implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private String login;
	
	private String senha;
	
	private List<GrantedAuthority> permissoes;
	
	public  CredencialDeAcesso(Usuario usuario) {
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		this.permissoes = new ArrayList<GrantedAuthority>();
		this.permissoes.add(new SimpleGrantedAuthority(usuario.getPapel().toString()));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPermissoes();
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
