package com.edu.pe.prueba;

import java.util.Collection;

import com.edu.pe.dao.DeptDAO;
import com.edu.pe.dao.EmpDAO;
import com.edu.pe.dao.EmpDAOMySqlImpl;
import com.edu.pe.dto.DeptDTO;
import com.edu.pe.dto.EmpDTO;
// ejemplo de uso del DAO sin servicio
public class Principal2 {

	public static void main(String[] args) {

		// instancio un DTO
		DeptDAO dept = new DeptDAO();
		// le pido la coleccion de todos los departamentos
		Collection<DeptDTO> coll = dept.buscarTodos();
		// itero la coleccion y muestro cada departamento (cada dto)
		for (DeptDTO dto : coll) {
			System.out.println(dto);
		}
		
		//EmpDAO empDAO = new EmpDAO(); antes de hacer abstracta la clase
		EmpDAO empDAO = new EmpDAOMySqlImpl(); //haciendo EmpDAO abstracto
		
		Collection<EmpDTO> empleadosDTO = empDAO.buscarXDept(1);
		
		for(EmpDTO empDTO : empleadosDTO) {
			System.out.println(empDTO);
		}

	}

}
