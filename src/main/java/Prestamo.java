public class Prestamo {
    private Socio socio;
    private Libro libro;
    private boolean devuelto;

    public Prestamo(Socio socio, Libro libro) {
        this.socio = socio;
        this.libro = libro;
        this.devuelto = false;
    }

    public void devolver() {
        this.devuelto = true;
    }

    public boolean estaDevuelto() {
        return devuelto;
    }

    // Se agregan getters para que el generador de comprobantes pueda leer los datos
    public Socio getSocio() {
        return socio;
    }

    public Libro getLibro() {
        return libro;
    }
}