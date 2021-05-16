package com.nuvu.clientes.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tipo_identificacion", schema = "public")
public class TipoIdentificacion implements java.io.Serializable {
    //@NotNull
    private Long idTipoIdentificacion;
    @NotNull
    @NotEmpty
    @Size(max = 10)
    private String codTipoIdentificacion;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String nombre;
    private List<Cliente> clientes = new ArrayList<Cliente>(0);

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Long idTipoIdentificacion,
        List<Cliente> clientes, String codTipoIdentificacion, String nombre) {
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.codTipoIdentificacion = codTipoIdentificacion;
        this.nombre = nombre;
        this.clientes = clientes;
    }

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_identificacion_seq_generator")
	@SequenceGenerator(name="tipo_identificacion_seq_generator", sequenceName="seq_id_tipo_identificacion",allocationSize=1)
    @Column(name = "id_tipo_identificacion", unique = true, nullable = false)
    public Long getIdTipoIdentificacion() {
        return this.idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(Long idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    @Column(name = "cod_tipo_identificacion", nullable = false)
    public String getCodTipoIdentificacion() {
        return this.codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(String codTipoIdentificacion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoIdentificacion")
    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
