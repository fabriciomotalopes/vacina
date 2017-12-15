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
public class AnimalBean {

	private Animal animalCadastrar;
	private List<Animal> lstAnimais;
	private List<Animal> lstAnimaisFind;
	private String acao = "novo";
	private Long idAnimal;
	private Long idVacina;
	
	private List<Vacina> listVacinas;
	private Vacina vacina;
	private AnimalVacinacao animalVacinacao;

	public Animal getAnimalCadastrar() {
		if (animalCadastrar == null) {
			animalCadastrar = new Animal();
		}
		return animalCadastrar;
	}

	public void setAnimalCadastrar(Animal animalCadastrar) {
		this.animalCadastrar = animalCadastrar;
	}

	public List<Animal> getLstAnimais() {
		return lstAnimais;
	}

	public void setLstAnimais(List<Animal> lstAnimal) {
		this.lstAnimais = lstAnimal;
	}

	public List<Animal> getLstAnimaisFind() {
		return lstAnimaisFind;
	}

	public void setLstAnimaisFind(List<Animal> lstAnimalFind) {
		this.lstAnimaisFind = lstAnimalFind;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}
	
	public List<Vacina> getListVacinas() {
		return listVacinas;
	}

	public void setListVacinas(List<Vacina> listVacinas) {
		this.listVacinas = listVacinas;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public AnimalVacinacao getAnimalVacinacao() {
		if (animalVacinacao == null) {
			animalVacinacao = new AnimalVacinacao();
		}
		return animalVacinacao;
	}

	public void setAnimalVacinacao(AnimalVacinacao animalVacinacao) {
		this.animalVacinacao = animalVacinacao;
	}
	
	
	
	public Long getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Long idVacina) {
		this.idVacina = idVacina;
	}

	public void salvar() {

		try {

			AnimalDAO dao = new AnimalDAO();

			Usuario user = new Usuario();
			UsuarioDAO userDao = new UsuarioDAO();

			user = userDao.buscarPorId(1L);

			animalCadastrar.setUsuario(user);
			dao.salvar(animalCadastrar);

			FacesUtil.adicionarMsgInfo("Animal Cadastrado com sucesso");
			animalCadastrar = new Animal();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar Cadastrar um Animal: " + ex.getMessage());
		}

	}

	public void listarAnimais() {
		try {

			AnimalDAO dao = new AnimalDAO();
			lstAnimais = dao.listar();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao carregar a lista de animais" + ex.getMessage());
		}
	}

	public void listarAnimalId() {
		try {

			if (idAnimal != null) {
				AnimalDAO dao = new AnimalDAO();
				animalCadastrar = dao.buscarPorId(Long.valueOf(idAnimal));
			}

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao carregar animal" + ex.getMessage());
		}
	}

	public String excluir() {

		try {

			AnimalDAO dao = new AnimalDAO();
			dao.excluir(animalCadastrar);

			FacesUtil.adicionarMsgInfo("Animal excluido com sucesso");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar excluir o Animal: " + ex.getMessage());
		}
		
		return "/animalListar.xhtml?faces-redirect=true";

	}

	public void editar() {

		try {

			AnimalDAO dao = new AnimalDAO();
			dao.editar(animalCadastrar);

			FacesUtil.adicionarMsgInfo("Animal Editar com sucesso");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgInfo("Erro ao tentar editar o Animal: " + ex.getMessage());
		}

	}
	
	public void carregarVacinasVacinarAnimal(){
		try {

			if (idAnimal != null) {
				AnimalDAO dao = new AnimalDAO();
				animalCadastrar = dao.buscarPorId(Long.valueOf(idAnimal));
				
				
			}
			
			VacinaDAO dao = new VacinaDAO();
			listVacinas = dao.listar();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao carregar Vacinas" + ex.getMessage());
		}
	}
	
	public String vacinarAnimal(){
		try {
			
				AnimalVacinacaoDAO animalVacinacaoDAO = new AnimalVacinacaoDAO();
				
				animalVacinacao.setVacina(vacina);
				animalVacinacao.setAnimal(animalCadastrar);
				
				animalVacinacaoDAO.salvar(animalVacinacao);	
				
				FacesUtil.adicionarMsgErro("Animal Vacinado com susseco!");		

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar vacinar animal" + ex.getMessage());
		}
		
		return "/animalListar.xhtml?faces-redirect=true";
		
	}

}
