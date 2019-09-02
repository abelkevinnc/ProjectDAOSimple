package com.edu.pe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.edu.pe.dto.EmpDTO;
import com.edu.pe.util.UConnection;

public abstract class EmpDAO {

	// cada implementacion debe sobrescribir este metodo
	// y retornar el sql propietario
	protected abstract String queryBuscarUltimosEmpleados();

	// este metodo ya no necesita ser abstracto porque
	// puede obtener el query invocando al metodo
	// abstracto queryBuscarUltimosEmpleados
	public Collection<EmpDTO> buscarUltimosEmpleados(int n) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = UConnection.getConnection();
			// el metodo abstracto me da el query a ejecutar
			String sql = queryBuscarUltimosEmpleados();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, n);
			rs = pstm.executeQuery();
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			EmpDTO dto = null;
			while (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setDeptno(rs.getInt("deptno"));
				ret.add(dto);
			}
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	// este metodo es comun a todas las bases de datos por lo tanto
	// podemos resolverlo aqui y no necesita ser declarado abstracto
	public Collection<EmpDTO> buscarXDept(int deptno) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = UConnection.getConnection();
			String sql = "";
			sql += "SELECT empno, ename, hiredate, deptno ";
			sql += "FROM emp ";
			sql += "WHERE deptno = ? ";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			rs = pstm.executeQuery();
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			EmpDTO dto = null;
			while (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setDeptno(rs.getInt("deptno"));
				ret.add(dto);
			}
			return ret;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}

	}

}