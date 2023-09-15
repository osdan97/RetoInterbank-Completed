package pe.reto.interbank.jurado.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CUOTAS")
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cuota;

    @Column(name = "fechaVencimiento", nullable = false)
    private LocalDate fechaVencimiento;
    @Column(name = "mensualidad", nullable = false)
    private double mensualidad;
    @Column(name = "intereses", nullable = false)
    private double intereses;
    @Column(name = "capital", nullable = false)
    private double capital;
    @Column(name = "saldo", nullable = false)
    private double saldo;
}
