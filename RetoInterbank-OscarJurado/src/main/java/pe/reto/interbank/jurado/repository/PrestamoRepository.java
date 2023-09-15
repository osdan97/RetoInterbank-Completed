package pe.reto.interbank.jurado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.reto.interbank.jurado.model.Cliente;
import pe.reto.interbank.jurado.model.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Integer>{


}
