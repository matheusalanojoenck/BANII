import dados.Mecanico;
import persistencia.DBConnection;
import persistencia.MecanicoDAO;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MecanicoDAO mecanicoDAO = MecanicoDAO.getInstance();

        //SELECT para mecanico com codm = 1
        Mecanico m = mecanicoDAO.select(1);
        System.out.println(m.toString());

        //Buscando todos os mecanicos cadastrados
        List<Mecanico> mecanicos = mecanicoDAO.selectAll();
        System.out.println(mecanicos);

        mecanicoDAO.insert(6, "12345678910", "Matheus", 40, "endereco", "Joinville", "estofado", 1);
        Mecanico m1 = mecanicoDAO.select(6);
        System.out.println(m1.toString());
        System.out.println(mecanicoDAO.selectAll());

        mecanicoDAO.delete(6);
        System.out.println(mecanicoDAO.selectAll());
    }
}
