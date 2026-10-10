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
//RESPUESTAS DE LAS PREGUNTAS DE GUIA.
//ACTIVIDAD 1.1
//1. Préstamo y Socio (Asociación), Préstamo y Libro (Asociación), Préstamo e Impresora (Dependencia)
//2. Socio (1) - Préstamo (0), Libro (1) - Préstamo (0)
//3. No bastaría. El enunciado diferencia conceptualmente los vínculos: afirma que el préstamo "guarda" al socio y al libro de forma que "siguen registrados" y se conservan "en el historial".
//4. Debería declarar como atributos un objeto de la clase Socio y un objeto de la clase Libro, ya que el requerimiento dicta directamente que "Cada préstamo guarda un socio y un libro".
//5. Un parámetro de tipo entero como int diasAtraso, el cual sirve para calcular el monto a pagar, dado que "La multa es de $500 por cada día de atraso". Un parámetro de tipo entero como int diasAtraso, el cual sirve para calcular el monto a pagar, dado que "La multa es de $500 por cada día de atraso".
//ACTIVIDAD 1.2
//1. Las Asociaciones se reflejan en la declaración de los atributos private Socio socio; y private Libro libro; dentro del bloque de la clase Prestamo. Esto demuestra estructuralmente que la clase retiene ambos objetos. La Dependencia se refleja en la firma del métod public void devolver(int diasAtraso, Impresora impresora), así como en la llamada interna impresora.imprimir(comprobante). La clase recibe el objeto como parámetro para usar su comportamiento de manera efímera, sin almacenarlo como atributo de clase.
//2. 2 asociaciones (de Prestamo hacia Socio y Libro) y 1 dependencia (de Prestamo hacia Impresora).
//3. No existe relación directa. Al examinar el Código 2, la clase Socio únicamente declara el atributo private String nombre;, y la clase Libro únicamente declara private String titulo;. Ninguna guarda una referencia de la otra. solo están relacionadas indirectamente al coexistir dentro de Prestamo.
//4. No, la clase Prestamo no cumple el Principio de Responsabilidad Única (SRP). Razones para cambiar: El código actual agrupa múltiples responsabilidades. La clase debería modificarse si cambia la estructura de los datos del préstamo (el estado devuelto), si cambian las reglas matemáticas del negocio (la operación diasAtraso * 500), o si cambia el diseño o formato del recibo impreso. Propuesta de separación: Debería extraerse la lógica de cálculo de la infracción y la generación del texto del recibo hacia una nueva clase especializada (por ejemplo, GestorComprobantes o CalculadoraMultas). De esta forma, Prestamo se limitaría exclusivamente a administrar el vínculo entre el socio, el libro y el estado del préstamo.