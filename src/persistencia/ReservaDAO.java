package persistencia;

import entidade.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO extends DAO {

    public void inserir(Reserva r) throws Exception {
        abrirConexao();
        stmt = con.prepareStatement("insert into reserva (numeroreserva,cpf,numeroquarto,checkin,checkout) values(?,?,?,?,?)");
        stmt.setInt(1, r.getNumeroReserva());
        stmt.setInt(2, r.getCpf());
        stmt.setInt(3, r.getNumeroQuarto());
        stmt.setDate(4, r.getCheckIn());
        stmt.setDate(5, r.getCheckOut());

        stmt.execute();

        stmt.close();

        fecharConexao();
    }

    public List<Reserva> buscarReserva() throws Exception {
        abrirConexao();
        stmt = con.prepareStatement("select * from quarto");
        rs = stmt.executeQuery();
        List<Reserva> lista = new ArrayList<Reserva>();
        while (rs.next()){
            Reserva r = new Reserva();
            
            r.setNumeroReserva(rs.getInt("numeroReserva"));
            r.setCpf(rs.getInt("cpf"));
            r.setNumeroQuarto(rs.getInt("numeroquarto"));
            r.setCheckIn(rs.getDate("checkin"));
            r.setCheckOut(rs.getDate("checkout"));
            
            lista.add(r);
        }
        rs.close();
        stmt.close();
        fecharConexao();
        return lista;
    }
    
    public void excluirQuarto(Integer id)throws Exception{
        
        abrirConexao();
        stmt = con.prepareStatement("delete from quarto where cod = ?");
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        
        fecharConexao();
        
    }
}
    