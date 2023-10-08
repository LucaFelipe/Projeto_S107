package Projeto_BD_POO.src.main.cadrasto.organizador;

public interface OrganizadorCRUD {

	boolean insertOrganizador(Organizador organizador);

	boolean searchOrganizador(int id);

	boolean updateOrganizador(Organizador organizador, int id);

	boolean deleteOrganizador(int id);
}