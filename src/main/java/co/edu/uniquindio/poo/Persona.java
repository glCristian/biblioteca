package co.edu.uniquindio.poo;

public class Persona {
    private String nombre;
    private String cedula;
    private int telefono;
    private String correo;

    /**
     * Método constructor de la clase Persona
     * 
     * @param nombre   del estudiante
     * @param cedula   del estudiante
     * @param telefono del estudiante
     * @param correo   del estudiante
     */
    public Persona(String nombre, String cedula, int telefono, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    // ---------------------Métodos get y set de la clase------------------//
    /**
     * Método para obtener el nombre de una persona
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para modificar el nombre de una persona
     * 
     * @param nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la cédula de una persona
     * 
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Método para modificar la cédula de una persona
     * 
     * @param cedula de la persona
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Método para obtener el número de teléfono de una persona
     * 
     * @return telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Método para modificar el número de teléfono de una persona
     * 
     * @param telefono de la persona
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener el correo de una persona
     * 
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método para modificar el correo de una persona
     * 
     * @param correo de la persona
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    // --------------------------------------------------------------------//

    /**
     * Método toString de la clase persona
     */
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo
                + "]";
    }

}
