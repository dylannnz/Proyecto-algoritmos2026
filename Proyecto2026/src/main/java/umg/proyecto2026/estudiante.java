/*⁠​‌​​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​​‌​​​​​​‌​‌‌​‌​​‌‌‌​‌​‌​‌‌​‌‌​​​‌‌​​‌​‌​‌‌‌​‌​​​‌‌​​​​‌​​‌​​​​​​​‌​‌​​​​‌‌​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌‌‌​‌​​​‌​‌​​‌​​‌​​​​​​‌‌‌‌‌​​​​‌​​​​​​‌​‌​​‌‌​‌‌​​​​‌​‌‌‌​​‌​​‌‌​​​​‌​​‌​​​​​​‌​‌​​​​​‌‌​​‌​‌​‌‌‌​​‌​​‌‌​​‌​‌​‌‌‌‌​‌​​​‌​​​​​​​‌​‌​​​​‌‌​​​​‌​‌‌​​​‌​​‌‌‌‌​​‌​​‌​‌‌​‌​​‌‌​​​​​​‌‌​‌‌​​‌‌​‌‌​‌​​‌​‌​​‌⁠
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.proyecto2026;

/**
 *
 * @author dygrz
 */
public class estudiante {
    private String carne;
    private String nombre;
    private String correo;
    private boolean asistio;

    public estudiante(String carne, String nombre, String correo) {
        this.carne = carne;
        this.nombre = nombre;
        this.correo = correo;
        this.asistio = false;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }
}
