package br.ufpb.dcx.agenda;

import java.io.Serializable;

public class Contato implements Serializable {
    private String nome;
    private int dia;
    private int mes;

    public Contato(String nome, int dia, int mes){
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
    }

    public Contato(){
        this("", 0, 0);
    }

    public String toString(){
        return "Aniversariante "+ this.nome+", que nasceu no Dia: " + dia + " Mês: " + mes;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getDia(){
        return this.dia;
    }
    public void setDia(int dia){
        this.dia = dia;
    }

    public int getMes(){
        return this.mes;
    }
    public void setMes(int mes){
        this.mes = mes;
    }

    public int getMesAniversario() {
        return this.mes;
    }

    public int getDiaAniversario() {
        return this.dia;
    }
}