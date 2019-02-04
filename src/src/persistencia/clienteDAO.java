
package persistencia;

import entidade.Cliente;
import java.util.ArrayList;
import java.util.List;

public class clienteDAO extends DAO {

	// inserir cliente
	public void inserir(Cliente C) throws Exception {

		abrirConexao();

		stmt = con.prepareStatement("insert into cliente (nome,rg,cpf,telefone) values (?,?,?,?)");

		// substituir as instruções
		//stmt.setInt(1, C.getCodigo());
		stmt.setString(1, C.getNome());
		stmt.setString(2, C.getRg());
		stmt.setString(3, C.getCpf());
		stmt.setString(4, C.getTelefone());
		

		// Executar a instrução
		stmt.execute();

		// Encerrar manipulação
		stmt.close();

		// fechar a conexao com o banco;
		fecharConexao();
	}

	// buscar cliente
	public List<Cliente> buscarCliente() throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from cliente;");
		// executar a query e armazenar o resultado
		// em uma variavel.
		rs = stmt.executeQuery();
		List<Cliente> lista = new ArrayList<Cliente>();
		while (rs.next()) {
			Cliente C = new Cliente();
			// C.setCodigo(rs.getInt("cod"));
			C.setNome(rs.getString("nome"));
			C.setRg(rs.getString("Rg"));
			C.setCpf(rs.getString("cpf"));
			C.setTelefone(rs.getString("Telefone"));
		
			
			// adiciono o objeto na lista
			lista.add(C);
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}
	
	public List<Cliente> buscarClienteEspecifico(String buscC) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from cliente where cpf = ?;");
		stmt.setString(1, buscC);
		// executar a query e armazenar o resultado
		// em uma variavel.
		rs = stmt.executeQuery();
		List<Cliente> lista = new ArrayList<Cliente>();
		while (rs.next()) {
			Cliente C = new Cliente();
			// C.setCodigo(rs.getInt("cod"));
			C.setNome(rs.getString("nome"));
			C.setRg(rs.getString("Rg"));
			C.setCpf(rs.getString("cpf"));
			C.setTelefone(rs.getString("Telefone"));
		
			
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
		stmt = con.prepareStatement("delete from Cliente where cpf = ?");

		stmt.setString(1, string);

		stmt.execute();
		stmt.close();

		fecharConexao();

	}

	public String atualizar(Cliente C) throws Exception {
		try {
			abrirConexao();
			stmt = con.prepareStatement(
					"update cliente set nome = ?, rg = ?, cpf = ?, telefone = ? where cpf = ?;");
			stmt.setString(1, C.getNome());
			stmt.setString(2, C.getRg());
			stmt.setString(3, C.getCpf());
			stmt.setString(4, C.getTelefone());
			stmt.setString(5, C.getUpdate());
			
			stmt.execute();
			stmt.close();
			fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar! " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		String st = "Cliente atualizado com sucesso!";
		return st;
	}
	
	public List<Cliente> visuCliente(Integer visu) throws Exception {

		abrirConexao();
		stmt = con.prepareStatement("select * from cliente where cpf = ?;");
		stmt.setInt(1, visu);
		// executar a query e armazenar o resultado
		// em uma variavel.
		rs = stmt.executeQuery();
		List<Cliente> lista = new ArrayList<Cliente>();
		while (rs.next()) {
			Cliente C = new Cliente();
			// C.setCodigo(rs.getInt("cod"));
			C.setNome(rs.getString("nome"));
			C.setRg(rs.getString("Rg"));
			C.setCpf(rs.getString("cpf"));
			C.setTelefone(rs.getString("Telefone"));
		
			
			// adiciono o objeto na lista
			lista.add(C);
		}

		rs.close();
		stmt.close();
		fecharConexao();
		return lista;
	}
}
