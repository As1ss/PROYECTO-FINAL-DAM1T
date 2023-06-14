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

	public RegistroFechas(String cliente, String tituloLibro, T fechaPedido, T fechaDevolucion) {
		this.cliente = cliente;
		this.tituloLibro = tituloLibro;
		this.fechaPedido = fechaPedido;
		this.fechaDevolucion = fechaDevolucion;
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

	public void guardarInformacion() {
		String nombreArchivo = cliente + "_" + tituloLibro + ".txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
			writer.write("Cliente: " + cliente);
			writer.newLine();
			writer.write("Título del libro: " + tituloLibro);
			writer.newLine();
			writer.write("Fecha de pedido: " + fechaPedido.toString());
			writer.newLine();
			writer.write("Fecha de devolución: " + fechaDevolucion.toString());
			writer.newLine();
			System.out.println("La información se ha guardado correctamente en el archivo: " + nombreArchivo);
		} catch (IOException e) {
			System.out.println("Error al guardar la información en el archivo: " + e.getMessage());
		}
	}
}