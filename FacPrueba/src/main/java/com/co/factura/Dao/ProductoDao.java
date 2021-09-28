package com.co.factura.Dao;

import com.co.factura.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductoDao implements IProductoDao {

    @PersistenceContext(unitName = "factura_PU")
    EntityManager em;

    @Override
    public List<Producto> listaproductos() {
    return em.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public Producto buscarPorId(Producto p) {
    return em.find(Producto.class, p.getIdProducto());
    }

    @Override
    public void insertarProducto(Producto p) {
    em.persist(p);
    }

    @Override
    public void modificarProducto(Producto p) {
    em.merge(p);
    }

    @Override
    public void eliminarProducto(Producto p) {
    em.remove(em.merge(p));
    }

}
