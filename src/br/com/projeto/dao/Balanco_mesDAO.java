/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Igrejas;
import br.com.projeto.model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class Balanco_mesDAO {

    //Concectar ao bando de dados
    private Connection con;

    public Balanco_mesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Metodo listar todos os clientes
    public double totalDizimo(int id_igreja, int mes, int ano) {
        double total = 0;
        try {
            //1 passo criar a lista

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select sum(valor) as total from tb_dizimos where id_igreja = ? and MONTH(data_dizimo) = ? and YEAR(data_dizimo) = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_igreja);
            stmt.setInt(2, mes);
            stmt.setInt(3, ano);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            while (rs.next()) {

                total = rs.getDouble("total");
            }
            return total;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return 0;
        }

    }

    // Metodo listar todos os clientes
    public double totalOferta(int id_igreja, int mes, int ano) {
        double total = 0;
        try {
            //1 passo criar a lista

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select sum(valor) as total from tb_ofertas where id_igreja = ? and MONTH(data_oferta) = ? and YEAR(data_oferta) = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_igreja);
            stmt.setInt(2, mes);
            stmt.setInt(3, ano);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            while (rs.next()) {

                total = rs.getDouble("total");
            }
            return total;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return 0;
        }

    }

        // Metodo listar todos os clientes
    public double totalDespesas(int id_igreja, int mes, int ano) {
        double total = 0;
        try {
            //1 passo criar a lista

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select sum(valor) as total from tb_despesas where id_igreja = ? and MONTH(data_despesa) = ? and YEAR(data_despesa) = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_igreja);
            stmt.setInt(2, mes);
            stmt.setInt(3, ano);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            while (rs.next()) {

                total = rs.getDouble("total");
            }
            return total;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return 0;
        }

    }
    
    
    
}
