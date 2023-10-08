package Projeto_BD_POO.src.main.test;

import Projeto_BD_POO.src.main.cadrasto.organizador.BD_organizador;
import Projeto_BD_POO.src.main.cadrasto.organizador.Organizador;
import Projeto_BD_POO.src.main.cadrasto.participante.BD_participante;
import Projeto_BD_POO.src.main.cadrasto.participante.Participante;

class TestMain {

    private BD_organizador bd_organizador;
    private BD_participante bd_participante;

    @BeforeEach
    void setUp() {
        bd_organizador = new BD_organizador();
        bd_participante = new BD_participante();
    }

    @Test
    @DisplayName("Teste de Inserção")
    void testInsert() {
        Organizador organizador = new Organizador();
        organizador.setId(1);
        organizador.setNomeEvento("Evento A");
        organizador.setNome("Organizador A");
        organizador.setCPF("111.111.111-11");
        organizador.setIdade(50);
        bd_organizador.insertOrganizador(organizador);

        Participante participante = new Participante();
        participante.setId(1);
        participante.setNome("Participante B");
        participante.setCPF("111.222.333-11");
        participante.setIdade(12);
        participante.setOrganizador_idOrganizador(1);
        bd_participante.insertParticipante(participante);
    }

    @Test
    @DisplayName("Teste de Pesquisa e Atualização")
    void testSearchAndUpdate() {
        Organizador organizador = new Organizador();
        organizador.setId(2);
        organizador.setNomeEvento("Evento B");
        organizador.setNome("Organizador B");
        organizador.setCPF("222.222.222-22");
        organizador.setIdade(40);
        bd_organizador.insertOrganizador(organizador);

        Participante participante = new Participante();
        participante.setId(2);
        participante.setNome("Participante C");
        participante.setCPF("222.333.444-22");
        participante.setIdade(25);
        participante.setOrganizador_idOrganizador(2);
        bd_participante.insertParticipante(participante);

        // Realize uma pesquisa (search) em Organizador
        Organizador org = bd_organizador.searchOrganizador(2);
        Assertions.assertNotNull(org);
        Assertions.assertEquals("Organizador B", org.getNome());

        // Realize uma atualização (update) em Participante
        participante.setNome("Participante D");
        bd_participante.updateParticipante(participante, 0);

        // Verifique se a atualização foi bem-sucedida
        Participante updatedParticipante = bd_participante.searchParticipante(2, 0);
        Assertions.assertNotNull(updatedParticipante);
        Assertions.assertEquals("Participante D", updatedParticipante.getNome());
    }

    @Test
    @DisplayName("Teste de Exclusão")
    void testDelete() {
        Organizador organizador = new Organizador();
        organizador.setId(3);
        organizador.setNomeEvento("Evento C");
        organizador.setNome("Organizador C");
        organizador.setCPF("333.333.333-33");
        organizador.setIdade(35);
        bd_organizador.insertOrganizador(organizador);

        // Realize uma exclusão (delete) em Organizador
        bd_organizador.deleteOrganizador(3);

        // Verifique se a exclusão foi bem-sucedida
        Organizador deletedOrganizador = bd_organizador.searchOrganizador(3);
        Assertions.assertNull(deletedOrganizador);
    }
}
