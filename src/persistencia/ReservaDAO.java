package persistencia;

import entidade.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDAO extends DAO {

	public boolean inserir(Reserva r) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement(
				"insert into reserva(numeroreserva,idlogin,numquarto,idcliente,checkin) values(null,?,?,?,?)");
		stmt.setInt(1, r.getIdlogin());
		stmt.setInt(3, r.getNumeroQuarto());
		stmt.setInt(2, r.getIdCliente());
		stmt.setTimestamp(4, r.getCheckIn());

		if (stmt.execute()) {
			stmt.close();
			fecharConexao();
			return true;
		} else {
			stmt.close();
			fecharConexao();
			return false;
		}

	}

	public void dispQuarto(Integer numeroQuarto, boolean disponibilidadeQuarto) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("update quarto set dispquarto = ? where numeroquarto = ?");

		stmt.setBoolean(1, disponibilidadeQuarto);
		stmt.setInt(2, numeroQuarto);

		stmt.execute();
		stmt.close();
		fecharConexao();

	}

	public List<Reserva> buscarReserva() throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("select * from reserva where 1");
		rs = stmt.executeQuery();
		List<Reserva> lista = new ArrayList<Reserva>();
		while (rs.next()) {

			Reserva r = new Reserva();

			r.setNumeroReserva(rs.getInt("numeroReserva"));
			r.setIdCliente(rs.getInt("idcliente"));
			r.setIdlogin(rs.getInt("idlogin"));
			r.setNumeroQuarto(rs.getInt("numquarto"));
			r.setCheckIn(rs.getTimestamp("checkin"));
			r.setCheckOut(rs.getTimestamp("checkout"));
			lista.add(r);

		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	public List<Reserva> buscarReservaEspecifica(Integer num) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from reserva where numeroreserva = ? order by numeroreserva limit 1");
		stmt.setInt(1, num);

		rs = stmt.executeQuery();

		List<Reserva> lista = new ArrayList<Reserva>();
		while (rs.next()) {
			Reserva r = new Reserva();

			r.setNumeroReserva(rs.getInt("numeroReserva"));
			r.setIdlogin(rs.getInt("idlogin"));
			r.setIdCliente(rs.getInt("idcliente"));
			r.setNumeroQuarto(rs.getInt("numquarto"));
			r.setCheckIn(rs.getTimestamp("checkin"));
			r.setCheckOut(rs.getTimestamp("checkout"));
			lista.add(r);
		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;

	}

	public String atualizarReserva(Reserva r) throws Exception {
		try {
			abrirConexao();
			stmt = con.prepareStatement(
					"update reserva set idcliente = ?, idlogin = ?, numquarto = ? where numeroreserva = ?");

			stmt.setInt(1, r.getIdCliente());
			stmt.setInt(2, r.getIdlogin());
			stmt.setInt(3, r.getNumeroQuarto());
			stmt.setInt(4, r.getUpdate());

			stmt.execute();

			stmt.close();
			fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar! " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		String st = "Reserva atualizada com sucesso!";
		return st;
	}

	public void excluirReserva(Integer id) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("delete from reserva where numeroreserva = ?");

		stmt.setInt(1, id);

		stmt.execute();
		stmt.close();

		fecharConexao();

	}
}
