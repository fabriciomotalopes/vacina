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

@Entity
@Table(name = "animal_vacinacao")
@NamedQueries({
	@NamedQuery(name = "AnimalVacinacao.listar", query = "SELECT animalVacinacao FROM AnimalVacinacao animalVacinacao"),
	@NamedQuery(name = "AnimalVacinacao.buscarPorId", query = "SELECT animalVacinacao FROM AnimalVacinacao animalVacinacao WHERE animalVacinacao.idAnimalVacinacao = :idAnimalVacinacao")
})
public class AnimalVacinacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_animal_vacinacao")
	private Long idAnimalVacinacao;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_vacinacao", nullable = false)
	private Date dataVacinacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "animal_id_animal", referencedColumnName = "id_animal")
	private Animal animal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vacina_id_vacina", referencedColumnName = "id_vacina")
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
	
}
