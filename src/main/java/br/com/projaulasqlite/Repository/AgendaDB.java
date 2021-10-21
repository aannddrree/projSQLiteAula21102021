package br.com.projaulasqlite.Repository;

import br.com.projaulasqlite.Model.Agenda;
import br.com.projaulasqlite.Utils.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDB {

    public void inserir (Agenda agenda){
        String sql = "INSERT INTO tb_agenda (nome, telefone) values (?,?)";
        try {
            Connection connection = Banco.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, agenda.getNome());
            pstmt.setString(2, agenda.getTelefone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update (Agenda agenda){
        String sql = "UPDATE tb_agenda set nome = ?, telefone = ? WHERE id = ?";
        try {
            Connection connection = Banco.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, agenda.getNome());
            pstmt.setString(2, agenda.getTelefone());
            pstmt.setInt(3, agenda.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete (int id){
        String sql = "DELETE FROM tb_agenda WHERE id = ?";
        try {
            Connection connection = Banco.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Agenda> finalAll(){
        List<Agenda> lst = new ArrayList<Agenda>();
        String sql = "SELECT id, nome, telefone FROM tb_agenda";

        try {
            Connection connection = Banco.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setNome(rs.getString("nome"));
                agenda.setTelefone(rs.getString("telefone"));
                lst.add(agenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;
    }
}
