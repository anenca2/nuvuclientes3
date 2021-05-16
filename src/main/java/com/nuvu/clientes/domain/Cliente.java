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
@Table(name = "cliente", schema = "public")
public class Cliente implements java.io.Serializable {
    //@NotNull
    private Long idCliente;
    @NotNull
    private TipoIdentificacion tipoIdentificacion;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String apellidos;
    private String codPostal;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String correo;
    @NotNull
    @NotEmpty
    @Size(max = 150)
    private String direccion;
    @NotNull
    private Date fechaNacimiento;
    @NotNull
    private Long identificacion;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String nombres;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String sexo;
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String telefono1;
    private String telefono2;
    private List<TarjetaCliente> tarjetaClientes = new ArrayList<TarjetaCliente>(0);

    public Cliente() {
    }

    public Cliente(Long idCliente, String apellidos, String codPostal,
        String correo, String direccion, Date fechaNacimiento,
        Long identificacion, String nombres, String sexo,
        List<TarjetaCliente> tarjetaClientes, String telefono1,
        String telefono2, TipoIdentificacion tipoIdentificacion) {
        this.idCliente = idCliente;
        this.tipoIdentificacion = tipoIdentificacion;
        this.apellidos = apellidos;
        this.codPostal = codPostal;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.sexo = sexo;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.tarjetaClientes = tarjetaClientes;
    }

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq_generator")
	@SequenceGenerator(name="cliente_seq_generator", sequenceName="seq_id_cliente",allocationSize=1)
    @Column(name = "id_cliente", unique = true, nullable = false)
    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_identificacion")
    public TipoIdentificacion getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @Column(name = "apellidos", nullable = false)
    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Column(name = "cod_postal")
    public String getCodPostal() {
        return this.codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @Column(name = "correo", nullable = false)
    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Column(name = "direccion", nullable = false)
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "fecha_nacimiento", nullable = false)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Column(name = "identificacion", nullable = false)
    public Long getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    @Column(name = "nombres", nullable = false)
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Column(name = "sexo", nullable = false)
    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Column(name = "telefono_1", nullable = false)
    public String getTelefono1() {
        return this.telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    @Column(name = "telefono_2")
    public String getTelefono2() {
        return this.telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    @OneToMany(mappedBy = "cliente")
    public List<TarjetaCliente> getTarjetaClientes() {
        return this.tarjetaClientes;
    }

    public void setTarjetaClientes(List<TarjetaCliente> tarjetaClientes) {
        this.tarjetaClientes = tarjetaClientes;
    }
}
