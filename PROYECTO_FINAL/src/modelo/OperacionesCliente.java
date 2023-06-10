package modelo;

import java.util.HashMap;

public class OperacionesCliente {
    private OperacionesAdministrador operaciones;

    public OperacionesCliente(OperacionesAdministrador operaciones) {
        this.operaciones = operaciones;
    }

    public void cogerLibro(int idLibro, Usuario usuario) {
        Libro libro = operaciones.consultarLibro(idLibro);
        if (libro != null && libro.getEjemplares() > 0 && usuario.getDisponibilidadPrestamo()) {
            libro.setEjemplares(libro.getEjemplares() - 1);
            usuario.agregarLibroPrestado(libro);
            System.out.println("El libro ha sido cogido por el cliente.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public void devolverLibro(int idLibro, Usuario usuario) {
        Libro libro = operaciones.consultarLibro(idLibro);
        if (libro != null && usuario.getDisponibilidadPrestamo()==false) {
            libro.setEjemplares(libro.getEjemplares() + 1);
            usuario.eliminarLibroPrestado();
            System.out.println("El libro ha sido devuelto por el cliente.");
        } else {
            System.out.println("El cliente no tiene prestado ese libro.");
        }
    }
}
