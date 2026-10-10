public class GeneradorComprobante {
    private static final int MULTA_POR_DIA = 500;

    public String generarRecibo(Socio socio, Libro libro, int diasAtraso) {
        int multa = diasAtraso > 0 ? diasAtraso * MULTA_POR_DIA : 0;

        return "Socio: " + socio.getNombre() +
                "\nLibro: " + libro.getTitulo() +
                "\nMulta: $" + multa;
    }
}