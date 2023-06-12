package modelo;

import java.time.LocalDate;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroFechas<C, L> {
	private C elemento;
	private L elemento2;
	private LocalDate fechaPedido;
	private LocalDate fechaDevolucion;

	public RegistroFechas(C elemento, L elementodos, LocalDate fechaPedido) {
		this.elemento = elemento;
		this.fechaPedido = fechaPedido;
		this.elemento2 = elementodos;
	}

	public C getElemento() {
		return elemento;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public L getElemento2() {
		return elemento2;
	}

	public void setElemento2(L elemento2) {
		this.elemento2 = elemento2;
	}

	public void setElemento(C elemento) {
		this.elemento = elemento;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public static List<RegistroFechas<String, String>> cargarRegistros(String archivo) {
		List<RegistroFechas<String, String>> listaRegistros = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;

			while ((linea = reader.readLine()) != null) {
				String cliente = linea.substring(linea.indexOf(":") + 2);

				linea = reader.readLine();
				String libro = linea.substring(linea.indexOf(":") + 2);

				linea = reader.readLine();
				LocalDate fechaPedido = LocalDate.parse(linea.substring(linea.indexOf(":") + 2));

				linea = reader.readLine();
				LocalDate fechaDevolucion = LocalDate.parse(linea.substring(linea.indexOf(":") + 2));

				RegistroFechas<String, String> registro = new RegistroFechas<>(cliente, libro, fechaPedido);
				registro.setFechaDevolucion(fechaDevolucion);
				listaRegistros.add(registro);

				// Leer la línea en blanco que separa los registros
				reader.readLine();
			}

			System.out.println("Se han cargado los registros del archivo '" + archivo + "'.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaRegistros;
	}

	public static void guardarRegistros(List<RegistroFechas<String, String>> listaRegistros, String archivo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
			for (RegistroFechas<String, String> registro : listaRegistros) {
				writer.write("");
				writer.write("Cliente: " + registro.getElemento());
				writer.newLine();
				writer.write("Libro: " + registro.getElemento2());
				writer.newLine();
				writer.write("Fecha de pedido: " + registro.getFechaPedido());
				writer.newLine();
				writer.write("Fecha de devolución: " + registro.getFechaDevolucion());
				writer.newLine();
				writer.newLine(); // Línea en blanco para separar los registros
			}

			System.out.println("Se han guardado los registros en el archivo '" + archivo + "'.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}