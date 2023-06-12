package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class MainTestFecha {

	public static void main(String[] args) {
		// Crear instancias de RegistroFechas para libros

		RegistroFechas<String, String> registroLibro1 = new RegistroFechas<>("Cliente1", "Libro1", LocalDate.now());
		RegistroFechas<String, String> registroLibro2 = new RegistroFechas<>("Cliente2", "Libro12", LocalDate.now());

		// Registrar fechas de devolución de libros
		registroLibro1.setFechaDevolucion(LocalDate.now().plusDays(7));
		registroLibro2.setFechaDevolucion(LocalDate.now().plusDays(10));

		// Obtener información de los registros de libros

		System.out.println("Cliente: " + registroLibro1.getElemento());
		System.out.println("Libro 1: " + registroLibro1.getElemento2());
		System.out.println("Fecha de pedido: " + registroLibro1.getFechaPedido());
		System.out.println("Fecha de devolución: " + registroLibro1.getFechaDevolucion());

		System.out.println("Cliente: " + registroLibro2.getElemento());
		System.out.println("Libro 2: " + registroLibro2.getElemento2());
		System.out.println("Fecha de pedido: " + registroLibro2.getFechaPedido());
		System.out.println("Fecha de devolución: " + registroLibro2.getFechaDevolucion());

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/documentos/historial.txt", true));

			writer.write("Cliente: " + registroLibro1.getElemento());
			writer.newLine();
			writer.write("Libro: " + registroLibro1.getElemento2());
			writer.newLine();
			writer.write("Fecha de pedido: " + registroLibro1.getFechaPedido());
			writer.newLine();
			writer.write("Fecha de devolución: " + registroLibro1.getFechaDevolucion());
			writer.newLine();
			writer.newLine();

			writer.write("Cliente: " + registroLibro2.getElemento());
			writer.newLine();
			writer.write("Libro: " + registroLibro2.getElemento2());
			writer.newLine();
			writer.write("Fecha de pedido: " + registroLibro2.getFechaPedido());
			writer.newLine();
			writer.write("Fecha de devolución: " + registroLibro2.getFechaDevolucion());
			writer.newLine();
			writer.newLine();

			writer.close();
			System.out.println("Los resultados se han guardado en el archivo 'historial.txt'.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
