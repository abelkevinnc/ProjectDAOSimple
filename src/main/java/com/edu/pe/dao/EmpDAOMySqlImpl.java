package com.edu.pe.dao;

//esta sentencia solo se ejecutará si hacemos uso de una bd mysql
public class EmpDAOMySqlImpl extends EmpDAO {

	@Override
	protected String queryBuscarUltimosEmpleados() {
		String sql = "";
		sql += "SELECT empno, ename, hiredate, deptno ";
		sql += "FROM emp ";
		sql += "ORDER BY hiredate DESC ";
		sql += "LIMIT ? ";
		return sql;
	}
	/*@Override
	public Collection<EmpDTO> buscarUltimosEmpleados(int n) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = UConnection.getConnection();
			// sentencia SQL propietaria de mysql
			String sql = "";
			sql += "SELECT empno, ename, hiredate, deptno ";
			sql += "FROM emp ";
			sql += "ORDER BY hiredate DESC ";
			sql += "LIMIT ? ";
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
	}*/

	

}
