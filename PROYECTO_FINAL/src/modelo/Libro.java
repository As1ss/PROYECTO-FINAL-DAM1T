package modelo;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Libro implements Serializable {
	private int id;
	private static int contadorID = 0;
	private String titulo;
	private String autor;
	private String editorial;
	private int ejemplares;
	private String estado;
	private ImageIcon img;


	public Libro(String titulo, String autor, String editorial, int ejemplares, String estado) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.ejemplares = ejemplares;
		this.estado = estado;
		img = new ImageIcon("src/images/default.png");
		img = redimensionarImagen(img, 100, 100);
		id = contadorID++;

	}

	public ImageIcon redimensionarImagen(ImageIcon img, int ancho, int alto) {
		Image imagen = img.getImage();
		Image redimension = imagen.getScaledInstance(alto, ancho, Image.SCALE_SMOOTH);
		return new ImageIcon(redimension);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
}
