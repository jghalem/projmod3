package persistencia;

import entidade.Quarto;

import java.util.ArrayList;
import java.util.List;

public class QuartoDAO extends DAO {

	public boolean inserir(Quarto q) throws Exception {
		try {
			abrirConexao();
			stmt = con.prepareStatement("insert into quarto (andarquarto,numeroquarto,dispquarto) values(?,?,?)");
			stmt.setInt(1, q.getAndarQuarto());
			stmt.setInt(2, q.getNumeroQuarto());
			stmt.setBoolean(3, q.isDispQuarto());

			stmt.execute();

			stmt.close();

			fecharConexao();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Quarto> buscarQuarto() throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("select * from quarto");
		rs = stmt.executeQuery();
		List<Quarto> lista = new ArrayList<Quarto>();
		while (rs.next()) {
			Quarto q = new Quarto();
			q.setAndarQuarto(rs.getInt("andarQuarto"));
			q.setNumeroQuarto(rs.getInt("numeroQuarto"));
			q.setDispQuarto(rs.getBoolean("dispQuarto"));
			lista.add(q);
		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	public List<Quarto> buscarQuartoEspecifico(Integer num) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from quarto where numeroquarto = ? order by andarquarto");
		stmt.setInt(1, num);

		rs = stmt.executeQuery();

		List<Quarto> lista = new ArrayList<Quarto>();
		while (rs.next()) {
			Quarto q = new Quarto();
			q.setAndarQuarto(rs.getInt("andarQuarto"));
			q.setNumeroQuarto(rs.getInt("numeroQuarto"));
			q.setDispQuarto(rs.getBoolean("dispQuarto"));
			lista.add(q);
		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;

	}

	public List<Quarto> buscarAndarEspecifico(Integer num) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from quarto where andarQuarto = ? order by numeroquarto");
		stmt.setInt(1, num);

		rs = stmt.executeQuery();

		List<Quarto> lista = new ArrayList<Quarto>();
		while (rs.next()) {
			Quarto q = new Quarto();
			q.setAndarQuarto(rs.getInt("andarQuarto"));
			q.setNumeroQuarto(rs.getInt("numeroQuarto"));
			q.setDispQuarto(rs.getBoolean("dispQuarto"));
			lista.add(q);
		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	public String excluirQuarto(Integer id) throws Exception {
		try {
			abrirConexao();
			stmt = con.prepareStatement("delete from quarto where numeroquarto = ?");

			stmt.setInt(1, id);

			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			System.out.println("Erro ao deletar!");
		}
		String st = "Quarto deletado com sucesso!";
		return st;
	}

	public String atualizarQuarto(Quarto q) throws Exception {
		try {
			abrirConexao();
			stmt = con.prepareStatement(
					"update quarto set andarQuarto = ?, numeroQuarto = ?, dispQuarto = ? where numeroQuarto = ?;");
			stmt.setInt(1, q.getAndarQuarto());
			stmt.setInt(2, q.getNumeroQuarto());
			stmt.setBoolean(3, q.isDispQuarto());
			stmt.setInt(4, q.getUpdate());

			stmt.execute();
			stmt.close();
			fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar! " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		String st = "Quarto atualizado com sucesso!";
		return st;
	}
}
