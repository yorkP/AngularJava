
package com.co.factura.Dao;

import com.co.factura.modelo.DetalleFactura;
import java.util.List;


public interface IDetalleFacturaDao {
    
    public List<DetalleFactura> listaDetalleFactura();
    
    public DetalleFactura buscarPorId(DetalleFactura dF);
    
    public void insertarDetFac(DetalleFactura dF);
    
    public void modificarDetFac(DetalleFactura dF);
    
    public void eliminarDetFac(DetalleFactura dF);
    
}
