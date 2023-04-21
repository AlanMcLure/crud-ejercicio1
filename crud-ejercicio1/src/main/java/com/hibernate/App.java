package com.hibernate;

import java.util.List;
import java.util.Scanner;

import com.hibernate.dao.CiudadDAO;
import com.hibernate.model.Ciudad;

public class App {

	public static void mostrarMenu() {
		System.out.println("-----MENÚ-----");
		System.out.println("1. Insertar nueva ciudad");
		System.out.println("2. Borrar una ciudad dado su código");
		System.out.println("3. Actualizar nombre ciudad dado su código");
		System.out.println("4. Actualizar habitantes de ciudad dado su código");
		System.out.println("5. Ver todas las ciudades");
		System.out.println("6. Ver los datos de una ciudad dado su código");
		System.out.println("7. Ver ciudades con más de 1 millón de habitantes");
		System.out.println("8. Ver ciudades con menos habitantes que una cantidad introducida");
		System.out.println("9. Mostrar los habitantes de la ciudad dada su nombre");
		System.out.println("0. Salir");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		int codigo;
		String nombre;
		Ciudad c;
		List<Ciudad> ciudades;

		Scanner entrada = new Scanner(System.in);
		CiudadDAO ciudadDAO = new CiudadDAO();

		do {
			mostrarMenu();
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Escribe el nombre de la ciudad: ");
				nombre = entrada.next();
				System.out.println("Escribe el número de habitantes de la ciudad: ");
				int numHabitantes = entrada.nextInt();
				c = new Ciudad(nombre, numHabitantes);
				ciudadDAO.insertCiudad(c);
				break;
			case 2:
				System.out.println("Escribe el código de la ciudad que quieres borrar: ");
				codigo = entrada.nextInt();
				ciudadDAO.deleteCiudad(codigo);
				break;
			case 3:
				System.out.println("Escribe el código de la ciudad que quieres actualizar el nombre: ");
				codigo = entrada.nextInt();
				c = ciudadDAO.selectCiudadByCodigo(codigo);
				System.out.println("Escribe el nombre de la ciudad: ");
				nombre = entrada.next();
				c.setNombre(nombre);
				ciudadDAO.updateCiudad(c);
				break;
			case 4:
				System.out.println("Escribe el código de la ciudad que quieres actualizar el número de habitantes: ");
				codigo = entrada.nextInt();
				c = ciudadDAO.selectCiudadByCodigo(codigo);
				System.out.println("Escribe el número de habitantes de la ciudad: ");
				numHabitantes = entrada.nextInt();
				c.setNumHabitantes(numHabitantes);
				ciudadDAO.updateCiudad(c);
				break;
			case 5:
				ciudades = ciudadDAO.selectAllCiudades();
				ciudades.forEach(ciu->System.out.println(ciu.getNombre() + " " + ciu.getNumHabitantes() + " habitantes"));
				break;
			case 6:
				System.out.println("Escribe el código de la ciudad que quieres ver los datos: ");
				codigo = entrada.nextInt();
				c = ciudadDAO.selectCiudadByCodigo(codigo);
				System.out.println(c.getCodigo() + ": " + c.getNombre() + " " + c.getNumHabitantes() + " habitantes");
				break;
			case 7:
				break;
			case 8:
				System.out.println("Escribe el número de habitantes que quieres de límite: ");
				numHabitantes = entrada.nextInt();
				
				break;
			case 9:
				System.out.println("Escribe el nombre de la ciudad: ");
				nombre = entrada.next();
				break;
			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Inserta un número del 0 al 6");
			}
		} while (opcion != 0);
	}

}