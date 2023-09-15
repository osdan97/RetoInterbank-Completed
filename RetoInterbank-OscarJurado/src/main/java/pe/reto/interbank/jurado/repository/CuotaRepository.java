package pe.reto.interbank.jurado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.reto.interbank.jurado.model.Cuota;

public interface CuotaRepository extends JpaRepository<Cuota,Integer> {
}
