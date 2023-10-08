package Projeto_BD_POO.src.main.classificação;

public interface ClassificacaoCRUD {

	void insertClassificacao(Classificacao classificacao);

	boolean searchClassificacao(int id, int idOrganizador);
	
	void updateClassificacao(Classificacao classificacao, int id, int idOrganizador);
	
	void deleteClassificacao(int id, int idOrganizador);

}