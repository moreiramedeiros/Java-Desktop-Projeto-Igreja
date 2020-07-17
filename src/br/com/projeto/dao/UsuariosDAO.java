/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Igrejas;
import br.com.projeto.model.Usuarios;
import br.com.projeto.view.FrmLogin;
import br.com.projeto.view.FrmMenu;
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
public class UsuariosDAO {

    //Concectar ao bando de dados
    private Connection con;

    public UsuariosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrarCliente
    public void cadastrarUsuario(Usuarios obj) {
        try {

            //1 passo - criar comando sql
            String sql = "insert into tb_usuarios (nome,data_nascimento,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,nivel_acesso,id_igreja,login,senha)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

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
            stmt.setString(15, obj.getNivel_acesso());
            stmt.setInt(16, obj.getIgreja().getId());
            stmt.setString(17, obj.getLogin());
            stmt.setString(18, obj.getSenha());

            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    // Metodo listar todos os clientes
    public List<Usuarios> listarUsuarios() {
        try {
            //1 passo criar a lista
            List<Usuarios> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select u.id,u.nome,u.data_nascimento,u.rg,u.cpf,u.email,u.telefone,u.celular,u.cep,u.endereco,u.numero,u.complemento,u.bairro,u.cidade,u.estado, u.login, u.senha, u.nivel_acesso, i.nome  from tb_usuarios as u "
                    + " left join tb_igrejas as i on (u.id_igreja = i.id)";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            while (rs.next()) {
                Usuarios obj = new Usuarios();

                obj.setId(rs.getInt("u.id"));
                obj.setNome(rs.getString("u.nome"));
                obj.setData_nascimento(rs.getString("u.data_nascimento"));
                obj.setCpf(rs.getString("u.cpf"));
                obj.setRg(rs.getString("u.rg"));
                obj.setEmail(rs.getString("u.email"));
                obj.setTelefone(rs.getString("u.telefone"));
                obj.setCelular(rs.getString("u.celular"));
                obj.setCep(rs.getString("u.cep"));
                obj.setEndereco(rs.getString("u.endereco"));
                obj.setNumero(rs.getInt("u.numero"));
                obj.setComplemento(rs.getString("u.complemento"));
                obj.setBairro(rs.getString("u.bairro"));
                obj.setCidade(rs.getString("u.cidade"));
                obj.setEstado(rs.getString("u.estado"));

                obj.setNivel_acesso(rs.getString("u.nivel_acesso"));
                obj.setLogin(rs.getString("u.login"));
                obj.setSenha(rs.getString("u.senha"));

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
    public void alterarUsuario(Usuarios obj) {
        try {

            //1 passo - criar comando sql
            String sql = "update tb_usuarios set nome=?, data_nascimento=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?,"
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, id_igreja=?, login=?, senha=?, nivel_acesso =?  where id=?;";

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
            stmt.setInt(15, obj.getIgreja().getId());

            stmt.setString(16, obj.getLogin());
            stmt.setString(17, obj.getSenha());
            stmt.setString(18, obj.getNivel_acesso());

            stmt.setInt(19, obj.getId());

            //3 passo - exacutar comando sql  
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    //Excluir igreja
    public void excluirUsuario(Usuarios obj) {
        try {

            //1 passo - criar comando sql
            String sql = "delete from tb_usuarios where id = ?;";

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
    public List<Usuarios> buscarUsuarioPorNome(String nome) {
        try {
            //1 passo criar a lista
            List<Usuarios> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select u.id,u.nome,u.data_nascimento,u.rg,u.cpf,u.email,u.telefone,u.celular,u.cep,u.endereco,u.numero,u.complemento,u.bairro,u.cidade,u.estado, u.login, u.senha, u.nivel_acesso, i.nome  from tb_usuarios as u "
                    + " left join tb_igrejas as i on (u.id_igreja = i.id) where u.nome like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            while (rs.next()) {
                Usuarios obj = new Usuarios();

                obj.setId(rs.getInt("u.id"));
                obj.setNome(rs.getString("u.nome"));
                obj.setData_nascimento(rs.getString("u.data_nascimento"));
                obj.setCpf(rs.getString("u.cpf"));
                obj.setRg(rs.getString("u.rg"));
                obj.setEmail(rs.getString("u.email"));
                obj.setTelefone(rs.getString("u.telefone"));
                obj.setCelular(rs.getString("u.celular"));
                obj.setCep(rs.getString("u.cep"));
                obj.setEndereco(rs.getString("u.endereco"));
                obj.setNumero(rs.getInt("u.numero"));
                obj.setComplemento(rs.getString("u.complemento"));
                obj.setBairro(rs.getString("u.bairro"));
                obj.setCidade(rs.getString("u.cidade"));
                obj.setEstado(rs.getString("u.estado"));

                obj.setNivel_acesso(rs.getString("u.nivel_acesso"));
                obj.setLogin(rs.getString("u.login"));
                obj.setSenha(rs.getString("u.senha"));

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
    public void login(String login, String senha) {
        try {
            //1 passo criar a lista

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select u.id,u.nome,u.data_nascimento,u.rg,u.cpf,u.email,u.telefone,u.celular,u.cep,u.endereco,u.numero,u.complemento,u.bairro,u.cidade,u.estado, u.login, u.senha, u.nivel_acesso, u.id_igreja,i.nome  from tb_usuarios as u "
                    + " left join tb_igrejas as i on (u.id_igreja = i.id) where (u.login = ? or u.email = ?) and u.senha = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, login);
            stmt.setString(3, senha);

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            if (rs.next()) {

               Usuarios obj = new Usuarios();

                obj.setId(rs.getInt("u.id"));
                obj.setNome(rs.getString("u.nome"));
                obj.setData_nascimento(rs.getString("u.data_nascimento"));
                obj.setCpf(rs.getString("u.cpf"));
                obj.setRg(rs.getString("u.rg"));
                obj.setEmail(rs.getString("u.email"));
                obj.setTelefone(rs.getString("u.telefone"));
                obj.setCelular(rs.getString("u.celular"));
                obj.setCep(rs.getString("u.cep"));
                obj.setEndereco(rs.getString("u.endereco"));
                obj.setNumero(rs.getInt("u.numero"));
                obj.setComplemento(rs.getString("u.complemento"));
                obj.setBairro(rs.getString("u.bairro"));
                obj.setCidade(rs.getString("u.cidade"));
                obj.setEstado(rs.getString("u.estado"));

                obj.setNivel_acesso(rs.getString("u.nivel_acesso"));
                obj.setLogin(rs.getString("u.login"));
                obj.setSenha(rs.getString("u.senha"));

                Igrejas igreja = new Igrejas();
                igreja.setNome(rs.getString("i.nome"));
                igreja.setId(rs.getInt("u.id_igreja"));
                obj.setIgreja(igreja);
                

                if (obj.getNivel_acesso().equals("Usuário")) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema como Usuário!!!");
                    
                    FrmMenu a = new FrmMenu();
                    a.lbusuario.setText(obj.getNome());
                    a.menuIgrejas.setVisible(false);
                    a.menuMembros.setVisible(false);
                    a.menuUsuarios.setVisible(false);
                    a.subMenuDespesas.setVisible(false);
                    a.subMenuDizimos.setVisible(false);
                    a.subMenuOfertas.setVisible(false);
                    a.setId_usuario(obj.getId());
                    a.setVisible(true);                    
                    
                    
                    
                    

                } else if(obj.getNivel_acesso().equals("Administrador Local")){
                    JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema como Administrador Local!!!");
                    FrmMenu a = new FrmMenu();
                    a.lbusuario.setText(obj.getNome());
                    a.menuIgrejas.setVisible(false);
                    a.menuUsuarios.setVisible(false);
                    a.setId_usuario(obj.getId());
    
                    a.setVisible(true);
                }else if(obj.getNivel_acesso().equals("Administrador Geral")){
                     JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema como Administrador Geral!!!");
                    FrmMenu a = new FrmMenu();
                    a.lbusuario.setText(obj.getNome());
                    a.setId_usuario(obj.getId());
  
                    a.setVisible(true);                   
                }

            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos!!!");
                    FrmLogin a = new FrmLogin();
                    a.setVisible(true);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }

    }
    
    
      // Metodo listar todos os clientes
    public Usuarios usuario(int id) {
        Usuarios obj=null;
        try {
            //1 passo criar a lista

            //2 passo - criar o comando sql, organizar e exacutar
            String sql = "select u.id,u.nome,u.data_nascimento,u.rg,u.cpf,u.email,u.telefone,u.celular,u.cep,u.endereco,u.numero,u.complemento,u.bairro,u.cidade,u.estado, u.login, u.senha, u.nivel_acesso, u.id_igreja,i.nome  from tb_usuarios as u "
                    + " left join tb_igrejas as i on (u.id_igreja = i.id) where u.id=? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
      

            ResultSet rs = stmt.executeQuery();

         //   while (rs.next()) {
            if (rs.next()) {

               obj = new Usuarios();

                obj.setId(rs.getInt("u.id"));
                obj.setNome(rs.getString("u.nome"));
                obj.setData_nascimento(rs.getString("u.data_nascimento"));
                obj.setCpf(rs.getString("u.cpf"));
                obj.setRg(rs.getString("u.rg"));
                obj.setEmail(rs.getString("u.email"));
                obj.setTelefone(rs.getString("u.telefone"));
                obj.setCelular(rs.getString("u.celular"));
                obj.setCep(rs.getString("u.cep"));
                obj.setEndereco(rs.getString("u.endereco"));
                obj.setNumero(rs.getInt("u.numero"));
                obj.setComplemento(rs.getString("u.complemento"));
                obj.setBairro(rs.getString("u.bairro"));
                obj.setCidade(rs.getString("u.cidade"));
                obj.setEstado(rs.getString("u.estado"));

                obj.setNivel_acesso(rs.getString("u.nivel_acesso"));
                obj.setLogin(rs.getString("u.login"));
                obj.setSenha(rs.getString("u.senha"));

                Igrejas igreja = new Igrejas();
                igreja.setNome(rs.getString("i.nome"));
                igreja.setId(rs.getInt("u.id_igreja"));
                obj.setIgreja(igreja);
                

             

            }  

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }
        
        return obj;

    }

    
    

}
