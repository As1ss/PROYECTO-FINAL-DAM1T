
/**

RegistroFechas es una clase genérica que representa un registro de fechas relacionadas con un pedido de libro.

Permite almacenar y guardar información sobre el cliente, el título del libro, la fecha de pedido y la fecha de devolución en un archivo de historial.

@param <T> el tipo de dato utilizado para representar las fechas (por ejemplo, Date, String, etc.)
*/
package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class RegistroFechas<T> {
	private T fechaPedido;
	private T fechaDevolucion;
	private String cliente;
	private String tituloLibro;
	private String archivoRegistros = "src/documentos/historial.txt";

	/**
	 * 
	 * Constructor de la clase RegistroFechas.
	 */
	public RegistroFechas() {

	}

	public T getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(T fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public T getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(T fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getCliente() {
		return cliente;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	/**
	 * 
	 * Guarda un registro en el archivo de historial.
	 * 
	 * @param cliente         el cliente asociado al registro
	 * @param tituloLibro     el título del libro asociado al registro
	 * @param fechaPedido     la fecha de pedido
	 * @param fechaDevolucion la fecha de devolución
	 */

	public void guardarRegistro(String cliente, String tituloLibro, String fechaPedido, String fechaDevolucion) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRegistros, true))) {
			writer.write("Cliente: " + cliente);
			writer.newLine();
			writer.write("Título del libro: " + tituloLibro);
			writer.newLine();
			writer.write("Fecha de pedido: " + fechaPedido);
			writer.newLine();
			writer.write("Fecha de devolución: " + fechaDevolucion);
			writer.newLine();
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			System.out.println("Error al guardar el registro en el archivo de historial: " + e.getMessage());
		}
	}
}