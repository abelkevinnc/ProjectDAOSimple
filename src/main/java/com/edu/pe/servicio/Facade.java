package com.edu.pe.servicio;

import java.util.Collection;

import com.edu.pe.dao.DeptDAO;
import com.edu.pe.dao.EmpDAO;
import com.edu.pe.dto.DeptDTO;
import com.edu.pe.dto.EmpDTO;
import com.edu.pe.util.UFactory;

public class Facade {

/*ESTO SE HACIA HARDCODEANDO LAS INSTANCIAS DE LOS DAOS*/
	
//	public Collection<DeptDTO> obtenerDepartamentos() {
//		DeptDAO deptDao = new DeptDAO();
//		return deptDao.buscarTodos();
//	}
//
//	public Collection<EmpDTO> obtenerEmpleados(int deptno) {
//		EmpDAO empDao = new EmpDAOMySqlImpl();
//		return empDao.buscarXDept(deptno);
//	}

/*AQUI PODEMOS USAR UN FACTORY QUE NOS PROVEA LAS INSTANCIAS DESDE UN FICHERO EXTERNO*/
	public Collection<DeptDTO> obtenerDepartamentos() {
		DeptDAO deptDao = (DeptDAO) UFactory.getInstancia("DEPT");
		return deptDao.buscarTodos();
	}

	public Collection<EmpDTO> obtenerEmpleados(int deptno) {
		EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
		return empDao.buscarXDept(deptno);
	}
	
	public Collection<EmpDTO> obtenerUltimosEmpleados(int n) {
		EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
		return empDao.buscarUltimosEmpleados(n);
	}

}
