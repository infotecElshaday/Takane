package br.com.takane.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity(name = "Usuario")
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_usuario")
	private Long id;

	@Column(nullable = false)
	@Size(min = 1, max = 70, message = "O nome do usuário deve ter no máximo 70 caracteres")
	private String nome;

	@Column(nullable = false)
	@Size(min = 1, max = 70, message = "A cidade do usuário deve ter no máximo 70 caracteres")
	private String cidade;

	@Email
	@Column(nullable = false)
	@Size(min = 1, max = 70, message = "O email do usuário deve ter no máximo 70 caracteres")
	private String email;

	@Column(nullable = false)
	@Size(min = 13, max = 14, message = "O telefone do usuário deve ter no máximo 13 caracteres")
	private String telefone;

	public Usuario() {

	}

	public Usuario(String nome, String cidade, String email, String telefone) {
		this.nome = nome;
		this.cidade = cidade;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
