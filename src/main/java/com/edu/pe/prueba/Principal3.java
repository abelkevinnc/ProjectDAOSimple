package com.edu.pe.prueba;

import java.util.Collection;
import java.util.Scanner;

import com.edu.pe.dto.DeptDTO;
import com.edu.pe.dto.EmpDTO;
import com.edu.pe.servicio.Facade;

//ejemplo listar departamentos y mostrar empleado, con clase de servicio (Facade)
public class Principal3 {
	public static void main(String[] args) {
		Facade facade = new Facade();
		Collection<DeptDTO> collDepts = facade.obtenerDepartamentos();
		// muestro los departamentos
		_mostrarDepartamentos(collDepts);
		// pido al usuario que ingrese un deptno
		Scanner scanner = new Scanner(System.in);
		int deptno = scanner.nextInt();
		Collection<EmpDTO> collEmps = facade.obtenerEmpleados(deptno);
		// muestro los empleados del deptno especifi cado
		_mostrarEmpleados(collEmps, deptno);
	}

	private static void _mostrarDepartamentos(Collection<DeptDTO> collDepts) {
		System.out.println("Departamentos: ");
		System.out.println("-------------------->");
		for (DeptDTO dto : collDepts) {
			System.out.print("| " + dto.getDeptno() + "\t");
			System.out.print("| " + dto.getDname() + "\t");
			System.out.println("| " + dto.getLoc() + "\t|");
		}
		System.out.println("<--------------------");
		System.out.print("Ingrese deptno: ");
	}

	private static void _mostrarEmpleados(Collection<EmpDTO> collEmps, int deptno) {
		System.out.println("Empleados del departamento: " + deptno);
		System.out.println("-------------------->");
		for (EmpDTO dto : collEmps) {
			System.out.print("| " + dto.getEmpno() + "\t");
			System.out.print("| " + dto.getEname() + "\t");
			System.out.println("| " + dto.getHiredate() + "\t|");
		}
		System.out.println("<--------------------");
	}
}
