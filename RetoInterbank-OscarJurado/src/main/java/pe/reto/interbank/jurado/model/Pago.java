package pe.reto.interbank.jurado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PAGO")
public class Pago {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Integer id_pago;

    @ManyToOne
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Prestamo prestamo;

    @Column(name = "fecha_pago", nullable = false, updatable = false)
    private Date fechaPago;

    @Column(name = "monto_abono", nullable = false)
    private Double montoAbono;

    @Column(name = "cuota", nullable = false)
    private Integer nroCuota;
}
