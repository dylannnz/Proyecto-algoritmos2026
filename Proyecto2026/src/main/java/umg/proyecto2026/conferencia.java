/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.proyecto2026;

/**
 *
 * @author dygrz
 */
public class conferencia {
    private int idConferencia;
    private String titulo;
    private String expositorAsignado;
    private String salon;

    public conferencia(int idConferencia, String titulo, String expositorAsignado, String salon) {
        this.idConferencia = idConferencia;
        this.titulo = titulo;
        this.expositorAsignado = expositorAsignado;
        this.salon = salon;
    }

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExpositorAsignado() {
        return expositorAsignado;
    }

    public void setExpositorAsignado(String expositorAsignado) {
        this.expositorAsignado = expositorAsignado;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
}
