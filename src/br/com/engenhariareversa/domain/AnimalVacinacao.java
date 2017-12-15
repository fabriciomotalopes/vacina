package br.com.engenhariareversa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "animal_vacinacao")
@NamedQueries({
	@NamedQuery(name = "AnimalVacinacao.listar", query = "SELECT animalVacinacao FROM AnimalVacinacao animalVacinacao"),
	@NamedQuery(name = "AnimalVacinacao.buscarPorId", query = "SELECT animalVacinacao FROM AnimalVacinacao animalVacinacao WHERE animalVacinacao.idAnimalVacinacao = :idAnimalVacinacao"),
	@NamedQuery(name = "AnimalVacinacao.buscarAnimal", query = "SELECT animalVacinacao FROM AnimalVacinacao animalVacinacao WHERE animalVacinacao.animal = :animal")
})
public class AnimalVacinacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_animal_vacinacao")
	private Long idAnimalVacinacao;
	
	@NotNull(message = "O campo data da vacinação é Obrigatório.")
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_vacinacao", nullable = false)
	private Date dataVacinacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idAnimal",insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Animal animal;
	
	@NotNull(message = "O campo vacina é obrigatório.")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idVacina",insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Vacina vacina;

	public Long getIdAnimalVacinacao() {
		return idAnimalVacinacao;
	}

	public void setIdAnimalVacinacao(Long idAnimalVacinacao) {
		this.idAnimalVacinacao = idAnimalVacinacao;
	}

	public Date getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	@Override
	public String toString() {
		return "AnimalVacinacao [idAnimalVacinacao=" + idAnimalVacinacao + ", dataVacinacao=" + dataVacinacao
				+ ", animal=" + animal + ", vacina=" + vacina + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAnimalVacinacao == null) ? 0 : idAnimalVacinacao.hashCode());
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
		AnimalVacinacao other = (AnimalVacinacao) obj;
		if (idAnimalVacinacao == null) {
			if (other.idAnimalVacinacao != null)
				return false;
		} else if (!idAnimalVacinacao.equals(other.idAnimalVacinacao))
			return false;
		return true;
	}
	
	
	
}
