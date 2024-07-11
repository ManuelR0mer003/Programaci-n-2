/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diani
 */
@Entity
@Table(name = "Reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByReservaId", query = "SELECT r FROM Reserva r WHERE r.reservaId = :reservaId")
    , @NamedQuery(name = "Reserva.findByFechaEntrada", query = "SELECT r FROM Reserva r WHERE r.fechaEntrada = :fechaEntrada")
    , @NamedQuery(name = "Reserva.findByFechaSalida", query = "SELECT r FROM Reserva r WHERE r.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Reserva.findByMontoTotalReserva", query = "SELECT r FROM Reserva r WHERE r.montoTotalReserva = :montoTotalReserva")
    , @NamedQuery(name = "Reserva.findByTipoPago", query = "SELECT r FROM Reserva r WHERE r.tipoPago = :tipoPago")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "reserva_id")
    private BigDecimal reservaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoTotalReserva")
    private BigDecimal montoTotalReserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipoPago")
    private String tipoPago;
    @JoinColumn(name = "actividadTuristica_id", referencedColumnName = "actividadTuristica_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActividadTuristica actividadTuristicaid;
    @JoinColumn(name = "alojamiento_id", referencedColumnName = "alojamiento_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Alojamiento alojamientoId;
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clienteId;
    @JoinColumn(name = "destinoTuristico_id", referencedColumnName = "destinoTuristico_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private DestinoTuristico destinoTuristicoid;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UsuarioAdministrador usuarioId;

    public Reserva() {
    }

    public Reserva(BigDecimal reservaId) {
        this.reservaId = reservaId;
    }

    public Reserva(BigDecimal reservaId, Date fechaEntrada, Date fechaSalida, BigDecimal montoTotalReserva, String tipoPago) {
        this.reservaId = reservaId;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.montoTotalReserva = montoTotalReserva;
        this.tipoPago = tipoPago;
    }

    public BigDecimal getReservaId() {
        return reservaId;
    }

    public void setReservaId(BigDecimal reservaId) {
        this.reservaId = reservaId;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getMontoTotalReserva() {
        return montoTotalReserva;
    }

    public void setMontoTotalReserva(BigDecimal montoTotalReserva) {
        this.montoTotalReserva = montoTotalReserva;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public ActividadTuristica getActividadTuristicaid() {
        return actividadTuristicaid;
    }

    public void setActividadTuristicaid(ActividadTuristica actividadTuristicaid) {
        this.actividadTuristicaid = actividadTuristicaid;
    }

    public Alojamiento getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(Alojamiento alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public DestinoTuristico getDestinoTuristicoid() {
        return destinoTuristicoid;
    }

    public void setDestinoTuristicoid(DestinoTuristico destinoTuristicoid) {
        this.destinoTuristicoid = destinoTuristicoid;
    }

    public UsuarioAdministrador getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioAdministrador usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaId != null ? reservaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.reservaId == null && other.reservaId != null) || (this.reservaId != null && !this.reservaId.equals(other.reservaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Reserva[ reservaId=" + reservaId + " ]";
    }
    
}
