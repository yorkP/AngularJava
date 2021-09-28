package com.co.factura.Dao;

import com.co.factura.modelo.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FacturaDao implements IFacturaDao {

    @PersistenceContext(unitName = "factura_PU")
    EntityManager em;

    @Override
    public List<Factura> listaFacturas() {
    return em.createNamedQuery("Factura.findAll").getResultList();
    }

    @Override
    public Factura buscarPorId(Factura f) {
    return em.find(Factura.class, f.getIdFactura());
    }

    @Override
    public Factura buscarPorCliente(Factura f) {
    return em.find(Factura.class, f.getCliente());
    }

    @Override
    public void insertarFactura(Factura f) {
    em.persist(f);
    }

    @Override
    public void modificarFactura(Factura f) {
    em.merge(f);
    }

    @Override
    public void eliminarFactura(Factura f) {
    em.remove(em.merge(f));
    }

}
