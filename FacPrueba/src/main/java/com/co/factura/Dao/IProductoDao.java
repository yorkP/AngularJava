
package com.co.factura.Dao;

import com.co.factura.modelo.Producto;
import java.util.List;


public interface IProductoDao {
    
    public List<Producto> listaproductos();
    
    public Producto buscarPorId(Producto p);
    
    public void insertarProducto(Producto p);
    
    public void modificarProducto(Producto p);
    
    public void eliminarProducto(Producto p);
    
}
