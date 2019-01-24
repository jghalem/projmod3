package persistencia;

import entidade.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

    public void inserir(Cliente c) throws Exception {
        abrirConexao();
        stmt = con.prepareStatement("insert into tb_cliente values(null,?,?,?)");
        //stmt.setInt(1, c.getCodigo());
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getEmail());
        stmt.setString(3, c.getSexo());

        stmt.execute();

        stmt.close();

        fecharConexao();
    }

    public List<Cliente> buscarCliente() throws Exception {
        abrirConexao();
        stmt = con.prepareStatement("select * from tb_cliente");
        rs = stmt.executeQuery();
        List<Cliente> lista = new ArrayList<Cliente>();
        while (rs.next()){
            Cliente c = new Cliente();
            c.setCodigo(rs.getInt("cod"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setSexo(rs.getString("sexo"));
            
            lista.add(c);
        }
        rs.close();
        stmt.close();
        fecharConexao();
        return lista;
    }
    
    public void excluirCliente(Integer id)throws Exception{
        
        abrirConexao();
        stmt = con.prepareStatement("delete from tb_cliente where cod = ?");
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        
        fecharConexao();
        
    }
}
    