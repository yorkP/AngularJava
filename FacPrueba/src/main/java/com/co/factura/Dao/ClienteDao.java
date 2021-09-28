package com.co.factura.Dao;

import com.co.factura.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteDao implements IClienteDao {
    
    @PersistenceContext(unitName = "factura_PU")
    EntityManager em;
    
    @Override
    public List<Cliente> listaClientes() {    
        return em.createNamedQuery("Cliente.findAll").getResultList();
    }
    
    @Override
    public Cliente buscarPorId(Cliente c) {
        return em.find(Cliente.class, c.getIdCliente());
    }
    
    @Override
    public Cliente buscarPorCorreo(Cliente c) {
        return em.find(Cliente.class, c.getEmail());
    }
    
    @Override
    public void insertarCliente(Cliente c) {
        em.persist(c);
        em.flush();
    }
    
    @Override
    public void modificarCliente(Cliente c) {
        em.merge(c);
    }
    
    @Override
    public void eliminarCliente(Cliente c) {
        em.remove(em.merge(c));
    }
    
}
