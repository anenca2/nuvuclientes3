package com.nuvu.clientes.domain;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tarjeta_cliente", schema = "public")
public class TarjetaCliente implements java.io.Serializable {
    @NotNull
    private TarjetaClienteId id;
    @NotNull
    private Cliente cliente;

    public TarjetaCliente() {
    }

    public TarjetaCliente(TarjetaClienteId id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "nroTarjeta",column = @Column(name = "nro_tarjeta",nullable = false)
        )
        , @AttributeOverride(name = "idCliente",column = @Column(name = "id_cliente",nullable = false)
        )
    })
    public TarjetaClienteId getId() {
        return this.id;
    }

    public void setId(TarjetaClienteId id) {
        this.id = id;
    }

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
