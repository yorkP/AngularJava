package com.co.factura.ServiciosRS;

import com.co.factura.Dao.IClienteDao;
import com.co.factura.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Stateless
@Path("/c")
public class ClienteRS {

    @Inject
    private IClienteDao iclienteDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Cliente> listCliente() {
        List<Cliente> clientes = iclienteDao.listaClientes();
        try {
            System.out.println(iclienteDao.getClass().getSimpleName());
            System.out.println("Lista de clientes desde el webservice: " + clientes);
            return clientes;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return clientes;
        }

    }

    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Cliente encontrarCliente(@PathParam("id") int id) {
        Cliente cliente = iclienteDao.buscarPorId(new Cliente(id));
        System.out.println("Cliente encontrada: " + cliente);
        return cliente;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Cliente agregarCliente(Cliente cliente) {
        iclienteDao.insertarCliente(cliente);
        System.out.println("Cliente agregado");
        return cliente;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarCliente(@PathParam("id") int id, Cliente clienteModificado) {
        Cliente cliente = iclienteDao.buscarPorId(new Cliente(id));
        if (clienteModificado != null) {
            iclienteDao.modificarCliente(clienteModificado);
            System.out.println("Cliente Modificado: " + clienteModificado);
            return Response.ok().entity(clienteModificado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteCliente(@PathParam("id") int id) {
        iclienteDao.eliminarCliente(new Cliente(id));
        System.out.println("Se ha eliminado el cliente con el id: " + id);
        return Response.ok().build();
    }

}
