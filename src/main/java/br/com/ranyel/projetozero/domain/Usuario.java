package br.com.ranyel.projetozero.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.ranyel.projetozero.domain.iface.BaseEntity;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements BaseEntity<Long> {

	/**
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	@NotNull(message = "O campo nome não pode estar vazio!")
	private String nome;

	@Column
	@NotNull(message = "O campo cpf não pode estar vazio!")
	private String cpf;

	@Column
	@NotNull(message = "O campo senha não pode estar vazio!")
	private String senha;

	@Column
	@NotNull(message = "O campo data de nascimento não pode estar vazio!")
	private Date dataNascimento;

	@Column
	@NotNull(message = "O campo telefone não pode estar vazio!")
	private String numeroTelefone;

	@JoinTable(name = "TB_PERFIL_USUARIO", 
			joinColumns = { @JoinColumn(name = "id_usuario", referencedColumnName = "id")}, 
			inverseJoinColumns = { @JoinColumn(name = "id_perfil", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Perfil> perfilList;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}