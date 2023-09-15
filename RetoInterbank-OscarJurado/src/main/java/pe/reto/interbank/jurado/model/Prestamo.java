package pe.reto.interbank.jurado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PRESTAMO")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prestamo;
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;
    @Column(name = "monto_abono", nullable = false)
    private double monto;
    @Column(name = "tasa_interes", nullable = false)
    private double tasaInteres;
    @Column(name = "numero_cuotas", nullable = false)
    private int numeroCuotas;
    @OneToMany(targetEntity = Cuota.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    private List<Cuota> cuotasList;

}
