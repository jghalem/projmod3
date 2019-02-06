
package persistencia;

import entidade.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class funcionarioDAO extends DAO {

	// inserir cliente
	public void inserir(Funcionario C) throws Exception {

		abrirConexao();

		stmt = con.prepareStatement("insert into Funcionario (nome,rg,cpf,contato,cargo) values (?,?,?,?,?)");

		// substituir as instruções
		// stmt.setInt(1, C.getCodigo());
		stmt.setString(1, C.getNome());
		stmt.setString(2, C.getRg());
		stmt.setString(3, C.getCpf());
		stmt.setString(4, C.getContato());
		stmt.setBoolean(5, C.isCargo());

		// Executar a instrução
		stmt.execute();

		// Encerrar manipulação
		stmt.close();

		// fechar a conexao com o banco;
		fecharConexao();
	}

	// buscar cliente
	public List<Funcionario> buscarFuncionario() throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from Funcionario;");
		// executar a query e armazenar o resultado
		// em uma variavel.
		rs = stmt.executeQuery();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		while (rs.next()) {
			Funcionario C = new Funcionario();
			// C.setCodigo(rs.getInt("cod"));
			C.setNome(rs.getString("nome"));
			C.setRg(rs.getString("Rg"));
			C.setCpf(rs.getString("cpf"));
			C.setContato(rs.getString("Contato"));
			C.setCargo(rs.getBoolean("Cargo"));

			// adiciono o objeto na lista
			lista.add(C);
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	public List<Funcionario> buscarFuncionarioEspecifico(String buscC) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from Funcionario where cpf = ?;");
		stmt.setString(1, buscC);
		// executar a query e armazenar o resultado
		// em uma variavel.
		rs = stmt.executeQuery();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		while (rs.next()) {
			Funcionario C = new Funcionario();
			// C.setCodigo(rs.getInt("cod"));
			C.setNome(rs.getString("nome"));
			C.setRg(rs.getString("Rg"));
			C.setCpf(rs.getString("cpf"));
			C.setContato(rs.getString("Contato"));
			C.setCargo(rs.getBoolean("Cargo"));

			// adiciono o objeto na lista
			lista.add(C);
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}

	// método de excluir cliente
	public void excluir(String string) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("delete from Funcionario where cpf = ?");

		stmt.setString(1, string);

		stmt.execute();
		stmt.close();

		fecharConexao();

	}

	public String atualizar(Funcionario C) throws Exception {
		try {
			abrirConexao();
			stmt = con.prepareStatement(
					"update funcionario set nome = ?, rg = ?, cpf = ?, contato = ?, cargo = ? where cpf = ?;");
			stmt.setString(1, C.getNome());
			stmt.setString(2, C.getRg());
			stmt.setString(3, C.getCpf());
			stmt.setString(4, C.getContato());
			stmt.setBoolean(5, C.isCargo());
			stmt.setString(6, C.getUpdate());

			stmt.execute();
			stmt.close();
			fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar! " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		String st = "empregado atualizado com sucesso!";
		return st;
	}

	public List<Funcionario> visuFuncionario(Integer visu) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from Funcionario where cpf = ?;");
		stmt.setInt(1, visu);
		// executar a query e armazenar o resultado
		// em uma variavel.
		rs = stmt.executeQuery();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		while (rs.next()) {
			Funcionario C = new Funcionario();
			// C.setCodigo(rs.getInt("cod"));
			C.setNome(rs.getString("nome"));
			C.setRg(rs.getString("Rg"));
			C.setCpf(rs.getString("cpf"));
			C.setContato(rs.getString("Contato"));
			C.setCargo(rs.getBoolean("Cargo"));

			// adiciono o objeto na lista
			lista.add(C);
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}
}
