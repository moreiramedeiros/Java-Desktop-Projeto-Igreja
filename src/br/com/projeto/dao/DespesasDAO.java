/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Igrejas;
import br.com.projeto.model.Despesas;
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
public class DespesasDAO {
    //Concectar ao bando de dados

    private Connection con;

    public DespesasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrarCliente
    public void cadastrarOferta(Despesas obj) {
        try {

            //1 passo - criar comando sql
            String sql = "insert into tb_despesas (descricao, valor, data_despesa, id_igreja)"
                    + "values (?,?,?,?);";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor());
            stmt.setString(3, obj.getData_despesa());
            stmt.setInt(4, obj.getIgreja().getId());

            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    // Metodo listar todos os clientes
    public List<Despesas> listarDespesas() {
        try {
            //1 passo criar a lista
            List<Despesas> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select d.id, d.descricao, d.valor, d.data_despesa, i.nome from tb_despesas as d "
                    + "inner join tb_igrejas as i on (d.id_igreja = i.id)";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Despesas obj = new Despesas();

                obj.setId(rs.getInt("d.id"));
                obj.setDescricao(rs.getString("d.descricao"));
                obj.setValor(rs.getDouble("d.valor"));
                obj.setData_despesa(rs.getString("d.data_despesa"));
                Igrejas igreja = new Igrejas();
                igreja.setNome(rs.getString("i.nome"));
                obj.setIgreja(igreja);

                lista.add(obj);
            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }

    //Alterar dizimo 
    public void alterarDespesa(Despesas obj) {
        try {

            //1 passo - criar comando sql
            String sql = "update tb_despesas set descricao=?, valor=?, data_despesa=?, id_igreja=? where id=?;";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor());
            stmt.setString(3, obj.getData_despesa());
            stmt.setInt(4, obj.getIgreja().getId());
            stmt.setInt(5, obj.getId());
            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    
             //Excluir igreja
        public void excluirDespesa(Despesas obj) {
        try {

            //1 passo - criar comando sql
            String sql = "delete from tb_despesas where id = ?;";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
    
    
    
      // Metodo listar todos os clientes
    public List<Despesas> buscarDespesasPorDescricao(String descricao) {
        try {
            //1 passo criar a lista
            List<Despesas> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select d.id, d.descricao, d.valor, d.data_despesa, i.nome from tb_despesas as d "
                    + "inner join tb_igrejas as i on (d.id_igreja = i.id) where d.descricao like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, descricao);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Despesas obj = new Despesas();

                obj.setId(rs.getInt("d.id"));
                obj.setDescricao(rs.getString("d.descricao"));
                obj.setValor(rs.getDouble("d.valor"));
                obj.setData_despesa(rs.getString("d.data_despesa"));
                Igrejas igreja = new Igrejas();
                igreja.setNome(rs.getString("i.nome"));
                obj.setIgreja(igreja);

                lista.add(obj);
            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }
    
    
    
    
    
        // Metodo listar todos os clientes
    public List<Despesas> listarDespesas(int id_igreja) {
        try {
            //1 passo criar a lista
            List<Despesas> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select d.id, d.descricao, d.valor, d.data_despesa, i.nome from tb_despesas as d "
                    + "inner join tb_igrejas as i on (d.id_igreja = i.id) where d.id_igreja = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_igreja);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Despesas obj = new Despesas();

                obj.setId(rs.getInt("d.id"));
                obj.setDescricao(rs.getString("d.descricao"));
                obj.setValor(rs.getDouble("d.valor"));
                obj.setData_despesa(rs.getString("d.data_despesa"));
                Igrejas igreja = new Igrejas();
                igreja.setNome(rs.getString("i.nome"));
                obj.setIgreja(igreja);

                lista.add(obj);
            }

            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }
    
    
    
}
