package br.com.senai.cardapiosmktplaceapi.entity;

import br.com.senai.cardapiosmktplaceapi.entity.enums.Papel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario {

	@Size(max = 50, message = "O login do usuário não deve conter mais de 50 caracteres")
	@NotBlank(message = "O login do usuário é obrigatório")
	@Column(name = "login")
	@EqualsAndHashCode.Include
	private String login;
	
	@NotBlank(message = "A senha do usuário é obrigatória")
	@Column(name = "senha")
	private String senha;
	
	@Size(max = 120, message = "O nome do usuário não deve conter mais de 120 caracteres")
	@Column(name = "nome")
	@NotBlank(message = "O nome do usuário é obrigatório")
	private String nome;
	
	@NotNull(message = "O papel do usuário é obrigatório")
	@Column(name = "papel")
	@Enumerated(value = EnumType.STRING)
	private Papel papel;
	
	
}
