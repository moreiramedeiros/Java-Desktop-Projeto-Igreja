/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Igrejas;
import br.com.projeto.model.Ofertas;
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
public class OfertasDAO {
    //Concectar ao bando de dados

    private Connection con;

    public OfertasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrarCliente
    public void cadastrarOferta(Ofertas obj) {
        try {

            //1 passo - criar comando sql
            String sql = "insert into tb_ofertas (descricao, valor, data_oferta, id_igreja)"
                    + "values (?,?,?,?);";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor());
            stmt.setString(3, obj.getData_oferta());
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
    public List<Ofertas> listarOfertas() {
        try {
            //1 passo criar a lista
            List<Ofertas> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select o.id, o.descricao, o.valor, o.data_oferta, i.nome from tb_ofertas as o "
                    + "inner join tb_igrejas as i on (o.id_igreja = i.id)";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ofertas obj = new Ofertas();

                obj.setId(rs.getInt("o.id"));
                obj.setDescricao(rs.getString("o.descricao"));
                obj.setValor(rs.getDouble("o.valor"));
                obj.setData_oferta(rs.getString("o.data_oferta"));
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
    public void alterarOferta(Ofertas obj) {
        try {

            //1 passo - criar comando sql
            String sql = "update tb_ofertas set descricao=?, valor=?, data_oferta=?, id_igreja=? where id=?;";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor());
            stmt.setString(3, obj.getData_oferta());
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
        public void excluirOferta(Ofertas obj) {
        try {

            //1 passo - criar comando sql
            String sql = "delete from tb_ofertas where id = ?;";

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
    public List<Ofertas> buscarOfertasPorDescricao(String descricao) {
        try {
            //1 passo criar a lista
            List<Ofertas> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select o.id, o.descricao, o.valor, o.data_oferta, i.nome from tb_ofertas as o "
                    + "inner join tb_igrejas as i on (o.id_igreja = i.id) where o.descricao like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, descricao);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ofertas obj = new Ofertas();

                obj.setId(rs.getInt("o.id"));
                obj.setDescricao(rs.getString("o.descricao"));
                obj.setValor(rs.getDouble("o.valor"));
                obj.setData_oferta(rs.getString("o.data_oferta"));
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
    public List<Ofertas> listarOfertas(int id_igreja) {
        try {
            //1 passo criar a lista
            List<Ofertas> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select o.id, o.descricao, o.valor, o.data_oferta, i.nome from tb_ofertas as o "
                    + "inner join tb_igrejas as i on (o.id_igreja = i.id) where o.id_igreja = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, id_igreja);
           
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ofertas obj = new Ofertas();

                obj.setId(rs.getInt("o.id"));
                obj.setDescricao(rs.getString("o.descricao"));
                obj.setValor(rs.getDouble("o.valor"));
                obj.setData_oferta(rs.getString("o.data_oferta"));
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
