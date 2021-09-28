package com.co.factura.Dao;

import com.co.factura.modelo.DetalleFactura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleFacturaDao implements IDetalleFacturaDao {

    @PersistenceContext(unitName = "factura_PU")
    EntityManager em;

    @Override
    public List<DetalleFactura> listaDetalleFactura() {
    return em.createNamedQuery("DetalleFactura.findAll").getResultList();
    }

    @Override
    public DetalleFactura buscarPorId(DetalleFactura dF) {
    return em.find(DetalleFactura.class, dF.getIdDetalleFactura());
    }

    @Override
    public void insertarDetFac(DetalleFactura dF) {
    em.persist(dF);
    em.flush();
    }

    @Override
    public void modificarDetFac(DetalleFactura dF) {
    em.merge(dF);
    }

    @Override
    public void eliminarDetFac(DetalleFactura dF) {
    em.remove(em.merge(dF));
    }

}
