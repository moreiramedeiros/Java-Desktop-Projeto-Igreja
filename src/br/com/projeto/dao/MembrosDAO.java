/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
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
public class MembrosDAO {
    
    
    //Concectar ao bando de dados
    private Connection con;
    public MembrosDAO(){
      this.con = new ConnectionFactory().getConnection();  
    }
    
    
      //Método cadastrarCliente
    public void cadastrarMembro(Membros obj) {
        try {

            //1 passo - criar comando sql
            String sql = "insert into tb_membros (nome,data_nascimento,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,cargo,id_igreja)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getData_nascimento());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getCpf());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getTelefone());
            stmt.setString(7, obj.getCelular());
            stmt.setString(8, obj.getCep());
            stmt.setString(9, obj.getEndereco());
            stmt.setInt(10, obj.getNumero());
            stmt.setString(11, obj.getComplemento());
            stmt.setString(12, obj.getBairro());
            stmt.setString(13, obj.getCidade());
            stmt.setString(14, obj.getEstado());
            stmt.setString(15, obj.getCargo());
            stmt.setInt(16, obj.getIgreja().getId());
            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
    
    
     
     // Metodo listar todos os clientes
    public List<Membros> listarMembros() {
        try {
            //1 passo criar a lista
            List<Membros> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
          

                        String sql = "select m.id,m.nome,m.data_nascimento,m.rg,m.cpf,m.email,m.telefone,m.celular,m.cep,m.endereco,m.numero,m.complemento,m.bairro,m.cidade,m.estado,m.cargo,i.nome from tb_membros as m "+
                                     " inner join tb_igrejas as i on (m.id_igreja = i.id)";
            
            
            
            
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
                
               while(rs.next()){
                Membros obj = new Membros();

                obj.setId(rs.getInt("m.id"));
                obj.setNome(rs.getString("m.nome"));
                obj.setData_nascimento(rs.getString("m.data_nascimento"));
                obj.setCpf(rs.getString("m.cpf"));
                obj.setRg(rs.getString("m.rg"));
                obj.setEmail(rs.getString("m.email"));
                obj.setTelefone(rs.getString("m.telefone"));
                obj.setCelular(rs.getString("m.celular"));
                obj.setCep(rs.getString("m.cep"));
                obj.setEndereco(rs.getString("m.endereco"));
                obj.setNumero(rs.getInt("m.numero"));
                obj.setComplemento(rs.getString("m.complemento"));
                obj.setBairro(rs.getString("m.bairro"));
                obj.setCidade(rs.getString("m.cidade"));
                obj.setEstado(rs.getString("m.estado"));
                obj.setCargo(rs.getString("m.cargo"));
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

           //Método alterarCliente

    public void alterarMembro(Membros obj) {
        try {
 
            //1 passo - criar comando sql
            String sql = "update tb_membros set nome=?, data_nascimento=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?,"
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, cargo=?, id_igreja=? where id=?;";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getData_nascimento());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getCpf());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getTelefone());
            stmt.setString(7, obj.getCelular());
            stmt.setString(8, obj.getCep());
            stmt.setString(9, obj.getEndereco());
            stmt.setInt(10, obj.getNumero());
            stmt.setString(11, obj.getComplemento());
            stmt.setString(12, obj.getBairro());
            stmt.setString(13, obj.getCidade());
            stmt.setString(14, obj.getEstado());
            stmt.setString(15, obj.getCargo());           
            stmt.setInt(16, obj.getIgreja().getId());          
            stmt.setInt(17, obj.getId());

            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
    
      //Excluir igreja
        public void excluirMembro(Membros obj) {
        try {

            //1 passo - criar comando sql
            String sql = "delete from tb_membros where id = ?;";

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
        
        
        
                  // Metodo buscar clientes por nome
    public List<Membros> buscaMembrosPorNome(String nome) {
        try {
            //1 passo criar a lista
            List<Membros> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            
             String sql = "select m.id,m.nome,m.data_nascimento,m.rg,m.cpf,m.email,m.telefone,m.celular,m.cep,m.endereco,m.numero,m.complemento,m.bairro,m.cidade,m.estado,m.cargo,i.nome from tb_membros as m "+
                                     " inner join tb_igrejas as i on (m.id_igreja = i.id)  where m.nome like ?";
            
 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Membros obj = new Membros();

                obj.setId(rs.getInt("m.id"));
                obj.setNome(rs.getString("m.nome"));
                obj.setData_nascimento(rs.getString("m.data_nascimento"));
                obj.setCpf(rs.getString("m.cpf"));
                obj.setRg(rs.getString("m.rg"));
                obj.setEmail(rs.getString("m.email"));
                obj.setTelefone(rs.getString("m.telefone"));
                obj.setCelular(rs.getString("m.celular"));
                obj.setCep(rs.getString("m.cep"));
                obj.setEndereco(rs.getString("m.endereco"));
                obj.setNumero(rs.getInt("m.numero"));
                obj.setComplemento(rs.getString("m.complemento"));
                obj.setBairro(rs.getString("m.bairro"));
                obj.setCidade(rs.getString("m.cidade"));
                obj.setEstado(rs.getString("m.estado"));
                obj.setCargo(rs.getString("m.cargo"));
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
    public List<Membros> listarMembrosPorIgreja(Igrejas igr) {
        try {
            //1 passo criar a lista
            List<Membros> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
          

                        String sql = "select m.id,m.nome,m.data_nascimento,m.rg,m.cpf,m.email,m.telefone,m.celular,m.cep,m.endereco,m.numero,m.complemento,m.bairro,m.cidade,m.estado,m.cargo,i.nome from tb_membros as m "+
                                     " inner join tb_igrejas as i on (m.id_igreja = i.id) where i.id = ? ";
            
            
            
            
            PreparedStatement stmt = con.prepareStatement(sql);

             stmt.setInt(1, igr.getId());
            
            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
                
               while(rs.next()){
                Membros obj = new Membros();

                obj.setId(rs.getInt("m.id"));
                obj.setNome(rs.getString("m.nome"));
                obj.setData_nascimento(rs.getString("m.data_nascimento"));
                obj.setCpf(rs.getString("m.cpf"));
                obj.setRg(rs.getString("m.rg"));
                obj.setEmail(rs.getString("m.email"));
                obj.setTelefone(rs.getString("m.telefone"));
                obj.setCelular(rs.getString("m.celular"));
                obj.setCep(rs.getString("m.cep"));
                obj.setEndereco(rs.getString("m.endereco"));
                obj.setNumero(rs.getInt("m.numero"));
                obj.setComplemento(rs.getString("m.complemento"));
                obj.setBairro(rs.getString("m.bairro"));
                obj.setCidade(rs.getString("m.cidade"));
                obj.setEstado(rs.getString("m.estado"));
                obj.setCargo(rs.getString("m.cargo"));
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
