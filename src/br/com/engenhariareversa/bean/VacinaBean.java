package br.com.engenhariareversa.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.engenhariareversa.dao.AnimalDAO;
import br.com.engenhariareversa.dao.AnimalVacinacaoDAO;
import br.com.engenhariareversa.dao.UsuarioDAO;
import br.com.engenhariareversa.dao.VacinaDAO;
import br.com.engenhariareversa.domain.Animal;
import br.com.engenhariareversa.domain.AnimalVacinacao;
import br.com.engenhariareversa.domain.Usuario;
import br.com.engenhariareversa.domain.Vacina;
import br.com.engenhariareversa.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VacinaBean {

	private Vacina vacinaCadastrar;
	private List<Vacina> vacinas;
	private List<Vacina> vacinasFilter;
	private List<AnimalVacinacao> animalVacinacaos;
	private List<AnimalVacinacao> animalVacinacaosFiltrados;
	private String acao = "novo";
	private Long idVacina;
	private Long idAnimal;

	public Vacina getVacinaCadastrar() {
		if (vacinaCadastrar == null) {
			vacinaCadastrar = new Vacina();
		}
		return vacinaCadastrar;
	}

	public void setVacinaCadastrar(Vacina vacinaCadastrar) {
		this.vacinaCadastrar = vacinaCadastrar;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}

	public List<Vacina> getVacinasFilter() {
		return vacinasFilter;
	}

	public void setVacinasFilter(List<Vacina> vacinasFilter) {
		this.vacinasFilter = vacinasFilter;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Long idVacina) {
		this.idVacina = idVacina;
	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}

	public List<AnimalVacinacao> getAnimalVacinacaos() {
		return animalVacinacaos;
	}

	public void setAnimalVacinacaos(List<AnimalVacinacao> animalVacinacaos) {
		this.animalVacinacaos = animalVacinacaos;
	}

	public List<AnimalVacinacao> getAnimalVacinacaosFiltrados() {
		return animalVacinacaosFiltrados;
	}

	public void setAnimalVacinacaosFiltrados(List<AnimalVacinacao> animalVacinacaosFiltrados) {
		this.animalVacinacaosFiltrados = animalVacinacaosFiltrados;
	}

	public void salvar() {

		try {

			VacinaDAO dao = new VacinaDAO();

			Usuario user = new Usuario();
			UsuarioDAO userDao = new UsuarioDAO();

			user = userDao.buscarPorId(1L);

			System.out.println(user.toString());
			System.out.println(vacinaCadastrar.toString());

			vacinaCadastrar.setUsuario(user);

			dao.salvar(vacinaCadastrar);

			FacesUtil.adicionarMsgInfo("Vacina Cadastrado com sucesso");
			vacinaCadastrar = new Vacina();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar Cadastrar um Vacina: " + ex.getMessage());
		}

	}

	public void listarVacinas() {
		try {

			VacinaDAO dao = new VacinaDAO();
			vacinas = dao.listar();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao carregar a lista de Vacinas" + ex.getMessage());
		}
	}

	public void listarVacinaId() {
		try {

			if (idVacina != null) {
				VacinaDAO dao = new VacinaDAO();
				vacinaCadastrar = dao.buscarPorId(Long.valueOf(idVacina));
			}

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao carregar Vacina" + ex.getMessage());
		}
	}

	public String excluir() {

		try {

			VacinaDAO dao = new VacinaDAO();
			dao.excluir(vacinaCadastrar);

			FacesUtil.adicionarMsgInfo("Vacina excluido com sucesso");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar excluir o Vacina: " + ex.getMessage());
		}

		return "/vacinasListar.xhtml?faces-redirect=true";

	}

	public void editar() {

		try {

			VacinaDAO dao = new VacinaDAO();
			dao.editar(vacinaCadastrar);

			FacesUtil.adicionarMsgInfo("Vacina Editar com sucesso");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar editar o Vacina: " + ex.getMessage());
		}

	}
	
	public void vizualizarVacinas(){
		try {

			AnimalVacinacaoDAO animalVacinacaoDAO = new AnimalVacinacaoDAO();
			AnimalDAO animalDAO = new AnimalDAO();
			
			Animal animal = animalDAO.buscarPorId(idAnimal);
			
			animalVacinacaos = animalVacinacaoDAO.buscarAnimal(animal);

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Vacina Editar com sucesso." + ex.getMessage());
		}
	}
	
	

	
}
