package pe.reto.interbank.jurado.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.reto.interbank.jurado.model.Cliente;
import pe.reto.interbank.jurado.repository.ClienteRepository;
import pe.reto.interbank.jurado.service.ClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> list() {

        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {

        cliente.setEstado(true);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editar(Integer dni, Cliente cliente) {
        if(!clienteRepository.existsById(dni)){
            throw new IllegalStateException("El dni no se encuentra registrado");
        }
        Optional<Cliente> existingCliente = clienteRepository.findById(dni);
        Cliente actualizarCliente=existingCliente.get();

        actualizarCliente.setDireccion(cliente.getDireccion());
        actualizarCliente.setDistrito(cliente.getDistrito());
        actualizarCliente.setTelefono(cliente.getTelefono());
        actualizarCliente.setEstado(cliente.getEstado());
        actualizarCliente.setProvincia(cliente.getProvincia());
        actualizarCliente.setCorreo(cliente.getCorreo());
        clienteRepository.save(actualizarCliente);
        return actualizarCliente;
    }

    @Override
    public Cliente darBaja(Integer dni) {

        if(!clienteRepository.existsById(dni)){
            throw new IllegalStateException("El dni no se encuentra registrado");
        }
        Optional<Cliente> existingCliente = clienteRepository.findById(dni);
        Cliente existCliente=existingCliente.get();
        existCliente.setEstado(false);
        clienteRepository.save(existCliente);
        return existCliente;
    }
}
