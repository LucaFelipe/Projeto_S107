package Projeto_BD_POO.src.main.cadrasto.partida;

public interface PartidaCRUD {

	boolean insertPartida(Partida partida);

	boolean searchPartida(int id, int idOrganizador);

	boolean updatePartida(Partida enfrenta, int id, int idOrganizador);

	boolean deletePartida(int id, int idOrganizador);
	
}