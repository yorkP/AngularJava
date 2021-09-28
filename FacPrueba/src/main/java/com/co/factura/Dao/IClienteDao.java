
package com.co.factura.Dao;

import com.co.factura.modelo.Cliente;
import java.util.List;


public interface IClienteDao {
    
    public List<Cliente> listaClientes();
    
    public Cliente buscarPorId(Cliente c);
    
    public Cliente buscarPorCorreo(Cliente c);
    
    public void insertarCliente(Cliente c);
    
    public void modificarCliente(Cliente c);
    
    public void eliminarCliente(Cliente c);
    
}
