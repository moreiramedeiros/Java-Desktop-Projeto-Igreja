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
public class Balanco_mes {

    private int id;
    private int mes;
    private int ano;
    private double valor_arrecadado;
    private double valor_deficit;
    private double valor_restante;
    private String data_regristro;
    private Igrejas igreja;
    
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor_arrecadado() {
        return valor_arrecadado;
    }

    public void setValor_arrecadado(double valor_arrecadado) {
        this.valor_arrecadado = valor_arrecadado;
    }

    public double getValor_deficit() {
        return valor_deficit;
    }

    public void setValor_deficit(double valor_deficit) {
        this.valor_deficit = valor_deficit;
    }

    public double getValor_restante() {
        return valor_restante;
    }

    public void setValor_restante(double valor_restante) {
        this.valor_restante = valor_restante;
    }

    public String getData_regristro() {
        return data_regristro;
    }

    public void setData_regristro(String data_regristro) {
        this.data_regristro = data_regristro;
    }

    public Igrejas getIgreja() {
        return igreja;
    }

    public void setIgreja(Igrejas igreja) {
        this.igreja = igreja;
    }

}
