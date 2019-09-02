package com.edu.pe.prueba;

import com.edu.pe.dao.DeptDAO;
import com.edu.pe.dao.EmpDAO;
import com.edu.pe.util.UFactory;

public class Principal4 {
	public static void main(String[] args) {
		EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
		System.out.println(empDao);
		DeptDAO deptDao = (DeptDAO) UFactory.getInstancia("DEPT");
		System.out.println(deptDao);
	}
}
