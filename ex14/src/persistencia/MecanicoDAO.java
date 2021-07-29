package persistencia;

import dados.Mecanico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MecanicoDAO {
    private static MecanicoDAO instance = null;
    private PreparedStatement selectMecanico;
    private PreparedStatement selectAllMacanico;
    private PreparedStatement insertMecanico;
    private PreparedStatement deleteMecanico;

    public static MecanicoDAO getInstance() {
        if (instance == null) instance = new MecanicoDAO();
        return instance;
    }

    private MecanicoDAO(){
        Connection connection = DBConnection.getConnection();
        try {
            selectMecanico = connection.prepareStatement(
                    "SELECT * " +
                            "FROM mecanico " +
                            "WHERE codm = ?");

            selectAllMacanico = connection.prepareStatement(
                    "SELECT * " +
                            "FROM mecanico");

            insertMecanico = connection.prepareStatement(
                    "INSERT INTO mecanico (codm, cpf, nome, idade, endereco, cidade, funcao, cods)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            deleteMecanico = connection.prepareStatement(
                    "DELETE FROM mecanico " +
                            "WHERE codm = ?");

        } catch (SQLException  | NullPointerException e){
            e.printStackTrace();
            //System.out.println(e.toString());
        }
    }

    public Mecanico select(int codm) {
        Mecanico m = null;
        ResultSet rs;
        try {
            selectMecanico.setInt(1, codm);
            rs = selectMecanico.executeQuery();
            if (rs.next()){
                m = new Mecanico();
                m.setCodm(rs.getInt("codm"));
                m.setCpf(rs.getString("cpf"));
                m.setNome(rs.getString("nome"));
                m.setIdade(rs.getInt("idade"));
                m.setEndereco(rs.getString("endereco"));
                m.setCidade(rs.getString("cidade"));
                m.setFuncao(rs.getString("funcao"));
                m.setCods(rs.getInt("cods"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public List<Mecanico> selectAll(){
        List<Mecanico> mecanicos = new ArrayList<>();
        ResultSet rs;

        try{
            rs = selectAllMacanico.executeQuery();
            while (rs.next()){
                mecanicos.add(select(rs.getInt(1)));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return mecanicos;
    }

    public void insert(int codm, String cpf, String nome, int idade, String endereco, String cidade, String funcao, int cods){
        try {
            insertMecanico.setInt(1, codm);
            insertMecanico.setString(2, cpf);
            insertMecanico.setString(3, nome);
            insertMecanico.setInt(4, idade);
            insertMecanico.setString(5, endereco);
            insertMecanico.setString(6, cidade);
            insertMecanico.setString(7, funcao);
            insertMecanico.setInt(8, cods);

            insertMecanico.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int codm){
        try {
            deleteMecanico.setInt(1, codm);

            deleteMecanico.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
