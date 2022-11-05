package br.ufpb.dcx.agenda;

import java.util.Collection;

/**
 * Operações básicas de uma agenda de aniversários
 */
public interface Agenda{

    /**
     * Cadastra novo contato na agenda
     * @param nome Nome do contato
     * @param dia Dia do aniversário do contato [1-31]
     * @param mes Mês do aniversário do contato [1-12]
     * @return true se foi possível cadastrar o contato e false, caso contrário
     *
     */
    public boolean cadastraContato(String nome, int dia, int mes);
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes);
    public boolean removeContato(String nome);
    public Collection<Contato> getContatos();

}