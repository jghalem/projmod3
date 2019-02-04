package persistencia;

import entidade.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginDAO extends DAO {

	public boolean inserir(Login l) throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("select cpf from funcionario where idfuncionario = ? limit 1");
		stmt.setInt(1, l.getIdfuncionario());

		rs = stmt.executeQuery();

		while (rs.next()) {
			l.setUsuario(rs.getString("cpf"));
		}

		stmt = con.prepareStatement(
				"insert into login (usuario,senha,isgerente,islogado,idfuncionario) values (?,?,?,?,?)");
		stmt.setString(1, l.getUsuario());
		stmt.setString(2, l.getSenha());
		stmt.setBoolean(3, l.isGerente());
		stmt.setBoolean(4, false);
		stmt.setInt(5, l.getIdfuncionario());

		stmt.execute();
		stmt.close();
		fecharConexao();
		return true;

	}

	public List<Login> buscarLogin() throws Exception {
		abrirConexao();
		stmt = con.prepareStatement("select * from login order by idlogin");
		rs = stmt.executeQuery();
		List<Login> lista = new ArrayList<Login>();
		while (rs.next()) {
			Login l = new Login();

			l.setUsuario(rs.getString("usuario"));
			l.setSenha(rs.getString("senha"));
			l.setGerente(rs.getBoolean("isGerente"));

			lista.add(l);
		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	public List<Login> buscarLoginEspecifico(String user) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from login where usuario = ? order by usuario limit 1");
		stmt.setString(1, user);

		rs = stmt.executeQuery();

		List<Login> lista = new ArrayList<Login>();
		while (rs.next()) {
			Login l = new Login();

			l.setUsuario(rs.getString("usuario"));
			l.setSenha(rs.getString("senha"));
			l.setGerente(rs.getBoolean("isGerente"));
			l.setLogado(rs.getBoolean("islogado"));
			lista.add(l);
		}
		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	public boolean buscarIsGerente(Integer idfuncionario) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select cargo from funcionario where idfuncionario = ? limit 1");
		stmt.setInt(1, idfuncionario);

		rs = stmt.executeQuery();

		boolean isgerente = false;
		while (rs.next()) {
			isgerente = rs.getBoolean("cargo");
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return isgerente;
	}

	public boolean defIsLogado(String usuario) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("update login set islogado = ? where usuario = ?");
		stmt.setBoolean(1, true);
		stmt.setString(2, usuario);

		stmt.execute();

		rs.close();
		stmt.close();
		fecharConexao();
		return true;

	}

	public boolean buscarIsLogado(String usuario) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select islogado from login where usuario = ?");
		stmt.setString(1, usuario);

		if (stmt.executeQuery() != null) {
			boolean isLogado = false;
			while (rs.next()) {
				isLogado = rs.getBoolean("cargo");
			}

			rs.close();
			stmt.close();
			fecharConexao();
			return isLogado;
		} else {
			return false;
		}

	}

	public boolean buscarLogados() throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from login where islogado = 1");

		stmt.executeQuery();

		List<Login> lista = new ArrayList<Login>();
		while (rs.next()) {
			Login l = new Login();

			l.setUsuario(rs.getString("usuario"));
			l.setSenha(rs.getString("senha"));
			l.setGerente(rs.getBoolean("isGerente"));
			l.setLogado(rs.getBoolean("islogado"));

			lista.add(l);
		}
		
		rs.close();
		stmt.close();
		fecharConexao();
		return true;

	}

	public String atualizarLogin(Login l) throws Exception {
		try {
			abrirConexao();
			stmt = con.prepareStatement("update login set usuario = ?, senha = ?, isgerente = ? where usuario = ?");
			stmt.setString(1, l.getUsuario());
			stmt.setString(2, l.getSenha());
			stmt.setBoolean(3, l.isGerente());
			stmt.setString(4, l.getUpdate());

			stmt.execute();
			stmt.close();
			fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar! " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		String st = "Login atualizado com sucesso!";
		return st;
	}

	public String fazerLoginUsuario(String user) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select usuario from login where usuario = ? order by usuario limit 1");
		stmt.setString(1, user);

		rs = stmt.executeQuery();

		String testeUsuario = "";
		while (rs.next()) {
			testeUsuario = rs.getString("usuario");
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return testeUsuario;
	}

	public String fazerLoginSenha(String senha) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select senha from login where senha = ?");
		stmt.setString(1, senha);

		rs = stmt.executeQuery();

		String testeSenha = "";
		while (rs.next()) {
			testeSenha = rs.getString("senha");
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return testeSenha;
	}

	public String excluirLogin(Integer id) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("delete from login where usuario = ?");

		stmt.setInt(1, id);

		stmt.execute();
		stmt.close();

		fecharConexao();
		String st = "Login deletado com sucesso!";
		return st;
	}
}
