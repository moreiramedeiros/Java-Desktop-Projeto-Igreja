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
public class Ofertas {

    private int id;
    private String descricao;
    private double valor;
    private String data_oferta;
    private Igrejas igreja;

   //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_oferta() {
        return data_oferta;
    }

    public void setData_oferta(String data_oferta) {
        this.data_oferta = data_oferta;
    }

    public Igrejas getIgreja() {
        return igreja;
    }

    public void setIgreja(Igrejas igreja) {
        this.igreja = igreja;
    }


}
