package com.nuvu.clientes.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Embeddable
public class TarjetaClienteId implements java.io.Serializable {
    @NotNull
    private Long nroTarjeta;
    @NotNull
    private Long idCliente;

    public TarjetaClienteId() {
    }

    @Column(name = "nro_tarjeta", nullable = false)
    public Long getNroTarjeta() {
        return this.nroTarjeta;
    }

    public void setNroTarjeta(Long nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    @Column(name = "id_cliente", nullable = false)
    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }

        if ((other == null)) {
            return false;
        }

        if (!(other instanceof TarjetaClienteId)) {
            return false;
        }

        TarjetaClienteId castOther = (TarjetaClienteId) other;

        return ((this.getNroTarjeta() == castOther.getNroTarjeta()) ||
        ((this.getNroTarjeta() != null) && (castOther.getNroTarjeta() != null) &&
        this.getNroTarjeta().equals(castOther.getNroTarjeta()))) &&
        ((this.getIdCliente() == castOther.getIdCliente()) ||
        ((this.getIdCliente() != null) && (castOther.getIdCliente() != null) &&
        this.getIdCliente().equals(castOther.getIdCliente())));
    }

    public int hashCode() {
        int result = 17;

        result = (37 * result) +
            ((getNroTarjeta() == null) ? 0 : this.getNroTarjeta().hashCode());
        result = (37 * result) +
            ((getIdCliente() == null) ? 0 : this.getIdCliente().hashCode());

        return result;
    }
}
