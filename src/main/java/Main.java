public class Main {
    public static void main(String[] args) {
        Socio socio = new Socio("Patricio Huenchuman");
        Libro libro = new Libro("Patrones de Diseño en Java");

        // Se genera el préstamo
        Prestamo prestamo = new Prestamo(socio, libro);

        // El socio devuelve el libro
        prestamo.devolver();
        int diasAtraso = 3;

        // Se calcula la multa y se genera el texto (SRP)
        GeneradorComprobante generador = new GeneradorComprobante();
        String textoComprobante = generador.generarRecibo(prestamo.getSocio(), prestamo.getLibro(), diasAtraso);

        // Se imprime el comprobante usando la impresora (Dependencia)
        Impresora impresora = new Impresora();
        impresora.imprimir(textoComprobante);
    }
}