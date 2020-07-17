/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilitarios;

import br.com.projeto.dao.DespesasDAO;
import br.com.projeto.dao.DizimosDAO;
import br.com.projeto.dao.OfertasDAO;
import br.com.projeto.model.Despesas;
import br.com.projeto.model.Dizimos;
import br.com.projeto.model.Ofertas;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class Relatorio {

    Utilitarios util = new Utilitarios();
    private String nomeIgreja;

    public int getId_igreja() {
        return id_igreja;
    }

    public void setId_igreja(int id_igreja) {
        this.id_igreja = id_igreja;
    }
    private int id_igreja;
    private double total_dizimos;
    private double total_ofertas;
    private double total_despesas;
    private double total_arrecadado;
    private double caixa_atual;
    private String mes;
    private String ano;
    private String dataHoje;
    private String horarioHoje;

    public Relatorio() {
        this.dataHoje = util.converteDataAtualParaBr();
        this.horarioHoje = util.getHoraAtual();
    }

    public String getNomeIgreja() {
        return nomeIgreja;
    }

    public void setNomeIgreja(String nomeIgreja) {
        this.nomeIgreja = nomeIgreja;
    }

    public double getTotal_dizimos() {
        return total_dizimos;
    }

    public void setTotal_dizimos(double total_dizimos) {
        this.total_dizimos = total_dizimos;
    }

    public double getTotal_ofertas() {
        return total_ofertas;
    }

    public void setTotal_ofertas(double total_ofertas) {
        this.total_ofertas = total_ofertas;
    }

    public double getTotal_despesas() {
        return total_despesas;
    }

    public void setTotal_despesas(double total_despesas) {
        this.total_despesas = total_despesas;
    }

    public double getTotal_arrecadado() {
        return total_arrecadado;
    }

    public double getCaixa_atual() {
        return caixa_atual;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String gerarRelatorioResumo() {
        total_arrecadado = total_dizimos + total_ofertas;
        caixa_atual = total_arrecadado - total_despesas;

        String txt
                = "<table border=\"1\" width=\"450\"  height=\"500\">\n"
                + "  \n"
                + "<tr>\n"
                + "<th align=\"center\"  valign=\"top\">\n"
                + "\n"
                + "\n"
                + "\n"
                + "<b>\n"
                + "<br>\n"
                + "<h2><u>Resumo do Mês de " + this.mes + " de " + this.ano + "</u></h2><br>\n"
                + "<br>\n"
                + "<table border=\"1\" width=\"300\">\n"
                + "<tr>\n"
                + "<th colspan=\"2\">\n"
                + "Nome: " + this.nomeIgreja + "<br>\n"
                + "</th>\n"
                + "</tr>\n"
                
                +"<tr bgcolor=\"yellow\">"
                + "<td>"
                + "Resumo"
                + "</td>"
                + "<td>"
                + "Valor"
                + "</td>"
                + "</tr>"
                
                
                
                + "<tr>\n"
                + "<td>\n"
                + "Total de Dízimos"
                + "</td>\n"
                + "<td>\n"
                + "R$ " + String.format("%.2f", this.total_dizimos) + "<br>\n"
                + "</td>\n"
                + "</tr>\n"
                
                + "<tr>\n"
                + "<td>\n"
                + "Total de Ofertas"
                + "</td>\n"
                + "<td>\n"
                + "R$ " + String.format("%.2f", this.total_ofertas) + "<br>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>\n"
                + "Total de Despesas"
                + "</td>\n"
                + "<td>\n"
                + "<font color=\"red\">R$ " + String.format("%.2f", this.total_despesas) + "</font><br>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>\n"
                + "Total de Arrecadado"
                + "</td>\n"
                + "<td>\n"
                + "R$ " + String.format("%.2f", this.total_arrecadado) + "<br>\n"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>\n"
                + "Caixa Atual"
                + "</td>\n"
                + "<td>\n"
                + "R$ " + String.format("%.2f", this.caixa_atual) + "<br>\n"
                + "</td>\n"
                + "</tr>\n"
                + "\n"
                + "\n"
                + "</table>\n"
                + "<b>\n"
                + " \n"
                + " \n"
                + "<i>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Pastor <br>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Secretário<br>\n"
                + "<br><br><br><br><br><br><br>\n"
                + "Data de Hoje: " + this.dataHoje + "; Horário: " + this.horarioHoje + " <br> <br><br>   \n"
                + "</th>\n"
                + "</tr></table><br><br>";
        return txt;
    }

    public String listarDizimos() {
        String txt = "";
        DizimosDAO dao = new DizimosDAO();
        List<Dizimos> lista = dao.listarDizimos(this.id_igreja);

        txt = txt + "<tr bgcolor=\"yellow\">"
                + "<td>"
                + "Membro"
                + "</td>"
                + "<td>"
                + "Valor"
                + "</td>"
                + "</tr>";

        for (Dizimos obj : lista) {
            txt = txt + "<tr >"
                    + "<td>"
                    + obj.getMembro().getNome()
                    + "</td>"
                    + "<td> R$ "
                    + obj.getValor()
                    + "</td>"
                    + "</tr>";
        }

        return txt;
    }

    public String gerarRelatorioDizimos() {

        String lista = listarDizimos();

        String txt
                = "<table border=\"1\" width=\"450\"  height=\"500\">\n"
                + "  \n"
                + "<tr>\n"
                + "<th align=\"center\"  valign=\"top\">\n"
                + "\n"
                + "\n"
                + "\n"
                + "<b>\n"
                + "<br>\n"
                + "<h2><u>Dízimos do Mês de " + this.mes + " de " + this.ano + "</u></h2><br>\n"
                + "<br>\n"
                + "<table border=\"1\" width=\"300\">\n"
                + "  \n"
                + "<tr>\n"
                + "<th colspan=\"2\">\n"
                + "Nome: " + this.nomeIgreja + "<br>\n"
                + "</th>\n"
                + "</tr>\n"
                
                + lista
                
 
                
                + "<tr>\n"
                + "<td>\n"
                + "Total de Dízimos"
                + "</td>\n"
                + "<td>\n"
                + "R$ " + String.format("%.2f", this.total_dizimos) + "<br>\n"
                + "</td>\n"
                + "</tr>\n"
                
                
                
                
                + "</table>\n"
                + "<b>\n"
                + " \n"
                + " \n"
                + "<i>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Pastor <br>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Secretário<br>\n"
                + "<br><br><br><br><br><br><br>\n"
                + "Data de Hoje: " + this.dataHoje + "; Horário: " + this.horarioHoje + " <br> <br><br>   \n"
                + "</th>\n"
                + "</tr></table><br><br>";
        return txt;
    }

    public String listarOfertas() {
        String txt = "";
        OfertasDAO dao = new OfertasDAO();
        List<Ofertas> lista = dao.listarOfertas(this.id_igreja);

        txt = txt + "<tr bgcolor=\"yellow\">"
                + "<td>"
                + "Descrição"
                + "</td>"
                + "<td>"
                + "Valor"
                + "</td>"
                + "</tr>";

        for (Ofertas obj : lista) {
            txt = txt + "<tr>"
                    + "<td>"
                    + obj.getDescricao()
                    + "</td>"
                    + "<td>R$ "
                    + obj.getValor()
                    + "</td>"
                    + "</tr>";
        }

        return txt;
    }

    public String gerarRelatorioOfertas() {

        String lista = listarOfertas();

        String txt
                = "<table border=\"1\" width=\"450\"  height=\"500\">\n"
                + "  \n"
                + "<tr>\n"
                + "<th align=\"center\"  valign=\"top\">\n"
                + "\n"
                + "\n"
                + "\n"
                + "<b>\n"
                + "<br>\n"
                + "<h2><u>Ofertas do Mês de " + this.mes + " de " + this.ano + "</u></h2><br>\n"
                + "<br><b>\n"
                
                + "<table border=\"1\" width=\"300\">\n"
                + "  \n"
                + "<tr>\n"
                + "<th colspan=\"2\">\n"
                + "Nome: " + this.nomeIgreja + "<br>\n"
                + "</th>\n"
                + "</tr>\n"
                + lista
                
                
                + "<tr>\n"
                + "<td>\n"
                + "Total de Ofertas"
                + "</td>\n"
                + "<td>\n"
                + "R$ " + String.format("%.2f", this.total_ofertas) + "<br>\n"
                + "</td>\n"
                + "</tr>\n"
                
                
                
                + "</table>\n"
                
                + "\n"
                + " \n"
                + " \n"
                + "<i>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Pastor <br>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Secretário<br>\n"
                + "<br><br><br><br><br><br><br>\n"
                + "<b>Data de Hoje: " + this.dataHoje + "; Horário: " + this.horarioHoje + "<b> <br> <br><br>   \n"
                + "</th>\n"
                + "</tr></table><br><br>";
        return txt;
    }

    public String listarDespesas() {
        String txt = "";
        DespesasDAO dao = new DespesasDAO();
        List<Despesas> lista = dao.listarDespesas(this.id_igreja);

        txt = txt + "<tr bgcolor=\"yellow\">"
                + "<td>"
                + "Descrição"
                + "</td>"
                + "<td>"
                + "Valor"
                + "</td>"
                + "</tr>";

        for (Despesas obj : lista) {
            txt = txt + "<tr>"
                    + "<td>"
                    + obj.getDescricao()
                    + "</td>"
                    + "<td>R$ "
                    + obj.getValor()
                    + "</td>"
                    + "</tr>";
        }

        return txt;
    }

    
    
        public String gerarRelatorioDespesas() {

        String lista = listarDespesas();

        String txt
                = "<table border=\"1\" width=\"450\"  height=\"500\">\n"
                + "  \n"
                + "<tr>\n"
                + "<th align=\"center\"  valign=\"top\">\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "<br>\n"
                + "<h2><u>Despesas do Mês de " + this.mes + " de " + this.ano + "</u></h2><br>\n"
                + "<br>\n"
                + "<table border=\"1\" width=\"300\">\n"
                + "  \n"
                + "<tr>\n"
                + "<th colspan=\"2\">\n"
                + "Nome: " + this.nomeIgreja + "<br>\n"
                + "</th>\n"
                + "</tr>\n"
                + lista
                
                + "<tr>\n"
                + "<td>\n"
                + "Total de Despesas"
                + "</td>\n"
                + "<td>\n"
                + "R$ " + String.format("%.2f", this.total_despesas) + "<br>\n"
                + "</td>\n"
                + "</tr>\n"
                
                
                + "</table>\n"
                + "\n"
                + " \n"
                + " \n"
                + "<i>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Pastor <br>\n"
                + "<br><br>___________________________________<br>\n"
                + "Assinatura do Secretário<br>\n"
                + "<br><br><br><br><br><br><br>\n"
                + "Data de Hoje: " + this.dataHoje + "; Horário: " + this.horarioHoje + " <br> <br><br>   \n"
                + "</th>\n"
                + "</tr></table><br><br>";
        return txt;
    }
    
    
    
    
    
    
    
    
}
