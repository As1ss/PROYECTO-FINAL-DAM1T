/**

La clase Libro representa un libro en el sistema.

Contiene métodos para obtener y establecer los atributos del libro, como el título, autor, editorial, ejemplares, estado y imagen.

Además, implementa la interfaz Serializable para permitir la serialización de objetos Libro.
*/
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

	/**
	 * 
	 * Crea una instancia de la clase Libro con los valores proporcionados. Además,
	 * asigna un valor único al atributo id incrementando el contador estático.
	 * 
	 * @param titulo     el título del libro
	 * @param autor      el autor del libro
	 * @param editorial  la editorial del libro
	 * @param ejemplares la cantidad de ejemplares disponibles del libro
	 * @param estado     el estado del libro
	 */

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
	/**

	Redimensiona la imagen del libro a las dimensiones especificadas.
	@param img la imagen del libro a redimensionar
	@param ancho el ancho deseado de la imagen redimensionada
	@param alto el alto deseado de la imagen redimensionada
	@return la imagen redimensionada como un objeto ImageIcon
	*/

	public ImageIcon redimensionarImagen(ImageIcon img, int ancho, int alto) {
		Image imagen = img.getImage();
		Image redimension = imagen.getScaledInstance(alto, ancho, Image.SCALE_SMOOTH);
		return new ImageIcon(redimension);

	}
	/**
	 * Getters y Setters
	 * @return
	 */

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
