package pe.reto.interbank.jurado.service;

import pe.reto.interbank.jurado.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> list();


    Cliente save(Cliente cliente) ;

    Cliente editar(Integer dni,Cliente cliente) ;

    Cliente darBaja(Integer dni);


}
