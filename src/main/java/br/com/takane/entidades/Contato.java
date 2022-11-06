package br.com.takane.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.takane.enumers.TipoContato;

@Entity
@Table(name = "contato", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", allocationSize = 1, initialValue = 1)
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_contato")
    private Long id;

    @Column(name = "nome", nullable = false)
    @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
    @NotNull(message = "O nome deve ser informado")
    private String nome;

    @Column(name = "email", nullable = false)
    @Size(max = 50, message = "O email deve ter no máximo 50 caracteres")
    @Email(message = "E-mail inválido")
    private String email;

    @Column(name = "cep", nullable = false)
    @Size(max = 8, message = "O cep deve ter no máximo 8 caracteres")
    @NotNull(message = "O cep do endereço deve ser informado")
    private String cep;

    @Column(name = "endereco", nullable = false)
    @Size(max = 50, message = "O endereço deve ter no máximo 50 caracteres")
    @NotNull(message = "O endereço deve ser informado")
    private String endereco;

    @Column(name = "numero", nullable = false)
    @Size(max = 7, message = "O numero dvee ter no máximo 7 caracteres")
    @NotNull(message = "O número do endereço deve ser informado")
    private String numero;

    @Column(name = "complemento", nullable = false)
    @Size(max = 40, message = "O complemento deve ter no máximo 40 caracteres")
    @NotNull(message = "O complemento do endereço deve ser informado")
    private String complemento;

    @Column(name = "bairro", nullable = false)
    @Size(max = 40, message = "O bairro deve ter no máximo 40 caracteres")
    @NotNull(message = "O bairro do endereço deve ser informado")
    private String bairro;

    @Column(name = "cidade", nullable = false)
    @Size(max = 50, message = "O nome  da cidade deve ter no máximo 50 caracteres")
    @NotNull(message = "O cidade do endereço deve ser informado")
    private String cidade;

    @Column(name = "estado", nullable = false)
    @Size(max = 2, message = "O nome  do estado deve ter no máximo 2 caracteres")
    @NotNull(message = "O estado do endereço deve ser informado")
    private String estado;

    @Column(name = "telefone", nullable = false)
    @Size(max = 14, message = "O telefone deve ter no máximo 14 caracteres")
    @NotNull(message = "Preenchimento obrigatórios")
    private String telefone;

    public Contato() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
