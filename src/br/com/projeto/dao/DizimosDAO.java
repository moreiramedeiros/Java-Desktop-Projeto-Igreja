/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Dizimos;
import br.com.projeto.model.Igrejas;
import br.com.projeto.model.Membros;
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
public class DizimosDAO {

    //Concectar ao bando de dados

    private Connection con;

    public DizimosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrarCliente
    public void cadastrarDizimo(Dizimos obj) {
        try {

            //1 passo - criar comando sql
            String sql = "insert into tb_dizimos (valor, data_dizimo, id_membro, id_igreja)"
                    + "values (?,?,?,?);";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, obj.getValor());
            stmt.setString(2, obj.getData_dizimo());
            stmt.setInt(3, obj.getMembro().getId());
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
    public List<Dizimos> listarDizimos() {
        try {
            //1 passo criar a lista
            List<Dizimos> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select d.id, d.valor, d.data_dizimo, m.nome, i.nome from tb_dizimos as d "
                    + "inner join tb_igrejas as i on (d.id_igreja = i.id) inner join tb_membros as m on (d.id_membro = m.id)";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            while (rs.next()) {
                Dizimos obj = new Dizimos();
                Membros membro = new Membros();
                Igrejas igreja = new Igrejas();

                obj.setId(rs.getInt("d.id"));
                obj.setValor(rs.getDouble("d.valor"));
                obj.setData_dizimo(rs.getString("d.data_dizimo"));
                membro.setNome(rs.getString("m.nome"));
                obj.setMembro(membro);
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
        public void alterarDizimo(Dizimos obj) {
        try {

            //1 passo - criar comando sql
            String sql = "update tb_dizimos set valor=?, data_dizimo=?, id_membro=?, id_igreja=? where id=?;";
  
            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, obj.getValor());
            stmt.setString(2, obj.getData_dizimo());
            stmt.setInt(3,obj.getMembro().getId());
            stmt.setInt(4,obj.getIgreja().getId());
            stmt.setInt(5,obj.getId());
            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
    
    
    
    
         //Excluir igreja
        public void excluirDizimo(Dizimos obj) {
        try {

            //1 passo - criar comando sql
            String sql = "delete from tb_dizimos where id = ?;";

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
    
    
    
             // Metodo  
    public List<Dizimos> buscaDizimistasPorNome(String nome) {
        try {
            //1 passo criar a lista
            List<Dizimos> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            
            
              String sql = "select d.id, d.valor, d.data_dizimo, m.nome, i.nome from tb_dizimos as d "
                    + "inner join tb_igrejas as i on (d.id_igreja = i.id) inner join tb_membros as m on (d.id_membro = m.id) where m.nome like ?";
  
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Dizimos obj = new Dizimos();
                Membros membro = new Membros();
                Igrejas igreja = new Igrejas();

                obj.setId(rs.getInt("d.id"));
                obj.setValor(rs.getDouble("d.valor"));
                obj.setData_dizimo(rs.getString("d.data_dizimo"));
                membro.setNome(rs.getString("m.nome"));
                obj.setMembro(membro);
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
    public List<Dizimos> listarDizimos(int id_igreja)  {
        try {
            //1 passo criar a lista
            List<Dizimos> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select d.id, d.valor, d.data_dizimo, m.nome, i.nome from tb_dizimos as d "
                    + "inner join tb_igrejas as i on (d.id_igreja = i.id) inner join tb_membros as m on (d.id_membro = m.id)  where d.id_igreja = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_igreja);
            
            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            while (rs.next()) {
                Dizimos obj = new Dizimos();
                Membros membro = new Membros();
                Igrejas igreja = new Igrejas();

                obj.setId(rs.getInt("d.id"));
                obj.setValor(rs.getDouble("d.valor"));
                obj.setData_dizimo(rs.getString("d.data_dizimo"));
                membro.setNome(rs.getString("m.nome"));
                obj.setMembro(membro);
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
