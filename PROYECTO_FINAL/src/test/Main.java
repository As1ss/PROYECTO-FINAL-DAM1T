package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "Valor 1");
		hashMap.put(2, "Valor 2");
		hashMap.put(3, "Valor 3");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream("usuarios.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(hashMap);

			objectOutputStream.close();
			System.out.println("El HashMap se agregó correctamente al archivo.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try

		{
			FileInputStream fileInputStream = new FileInputStream("usuarios.dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			// Leer el HashMap del archivo
			Map<Integer, String> hashMap2 = (Map<Integer, String>) objectInputStream.readObject();

			objectInputStream.close();

			// Visualizar el HashMap leído
			for (Map.Entry<Integer, String> entry : hashMap2.entrySet()) {
				System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}