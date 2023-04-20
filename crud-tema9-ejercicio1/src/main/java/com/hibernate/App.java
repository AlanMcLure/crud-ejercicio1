package com.hibernate;

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
		System.out.println("0. Salir");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		int codigo;
		String nombre;
		Ciudad c;

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
				System.out.println("Escribe el código de la ciudad que quieres actualizar el nombre ");
				codigo = entrada.nextInt();
				c = ciudadDAO.selectCiudadByCodigo(codigo);
				System.out.println("Escribe el nombre de la ciudad: ");
				nombre = entrada.next();
				c.setNombre(nombre);
				ciudadDAO.updateCiudad(c);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 0:
				break;
			default:
			}
		} while (opcion != 0);
	}

}
