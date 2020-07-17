/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model;

/**
 *
 * @author Isaac
 */
public class Dizimos {

    private int id;
    private double valor;
    private String data_dizimo;
    private Membros membro;
    private Igrejas igreja;
    
   //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_dizimo() {
        return data_dizimo;
    }

    public void setData_dizimo(String data_dizimo) {
        this.data_dizimo = data_dizimo;
    }

    public Membros getMembro() {
        return membro;
    }

    public void setMembro(Membros membro) {
        this.membro = membro;
    }

    public Igrejas getIgreja() {
        return igreja;
    }

    public void setIgreja(Igrejas igreja) {
        this.igreja = igreja;
    }

}
