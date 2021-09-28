
package com.co.factura.Dao;

import com.co.factura.modelo.Factura;
import java.util.List;

public interface IFacturaDao {
    
    public List<Factura> listaFacturas();
    
    public Factura buscarPorId(Factura f);
    
    public Factura buscarPorCliente(Factura f);
    
    public void insertarFactura(Factura f);
    
    public void modificarFactura(Factura f);
    
    public void eliminarFactura(Factura f);
    
}
