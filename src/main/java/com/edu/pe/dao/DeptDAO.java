package com.edu.pe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.edu.pe.dto.DeptDTO;
import com.edu.pe.util.UConnection;

public class DeptDAO {
	public Collection<DeptDTO> buscarTodos() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = UConnection.getConnection();
			String sql = "SELECT deptno, dname, loc FROM dept ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			Vector<DeptDTO> departamentos = new Vector<DeptDTO>();
			DeptDTO dtoDept = null;
			while (rs.next()) {
				dtoDept = new DeptDTO();
				dtoDept.setDeptno(rs.getInt("deptno"));
				dtoDept.setDname(rs.getString("dname"));
				dtoDept.setLoc(rs.getString("loc"));
				departamentos.add(dtoDept);
			}
			return departamentos;
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