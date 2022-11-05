package br.ufpb.dcx.agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class AgendaSearchController implements ActionListener{
    private Agenda agenda;
    private JFrame janelaPrincipal;

    public AgendaSearchController(Agenda agenda, JFrame janelaPrincipal){
        this.agenda = agenda;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual dia do mês a pesquisar?"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o mês a pesquisar?"));
        Collection<Contato> aniversariantes = agenda.pesquisaAniversariantes(dia, mes);

        if(aniversariantes.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariantes encontrados:");


            for (Contato c: aniversariantes){
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }

        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum aniversariante nesta data");
        }
    }

}
