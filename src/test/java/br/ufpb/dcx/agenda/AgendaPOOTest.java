package br.ufpb.dcx.agenda;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgendaPOOTest {

    @Test
    public void testaConstrutorAgenda(){
        AgendaPOO agenda = new AgendaPOO();
        assertTrue(agenda.getContatos().size()==0);
    }

    @Test
    public void testaCadastrarContatoEPesquisarAnivesariantesData(){
        AgendaPOO agenda = new AgendaPOO();
        assertTrue(agenda.getContatos().size()==0);
        assertEquals(0, agenda.pesquisaAniversariantes(5,10).size());
        agenda.cadastraContato("Ana", 5, 10);
        assertEquals(1, agenda.pesquisaAniversariantes(5,10).size());
        agenda.cadastraContato("Maria", 5, 10);
        assertEquals(2, agenda.pesquisaAniversariantes(5,10).size());
        assertEquals(0, agenda.pesquisaAniversariantes(1,1).size());
        assertEquals(2, agenda.getContatos().size());
        agenda.cadastraContato("João", 3, 12);
        assertEquals(1, agenda.pesquisaAniversariantes(3, 12).size());
        agenda.removeContato("João");
    }
}
