package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class mariaDB {

	static String url = "jdbc:mysql://45.119.145.165:3306/catchmine";
	static String id = "root";
	static String pass = "daehwan";
	static Connection conn = null;
	static PreparedStatement pstmt = null;

	private static String NickName;

	public static String getNickName() {
		return NickName;
	}

	public boolean LoginCheck(JTextField idText, JTextField pwText) {
		if (!idText.getText().isEmpty() && !pwText.getText().isEmpty())
			try {
				pstmt = null;
				String selectSql = "select * from CatchMine";
				pstmt = conn.prepareStatement(selectSql);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					if (idText.getText().equals(rs.getString(1)))
						if (pwText.getText().equals(rs.getString(2))) {
							NickName = rs.getString(4);
							return true;
						}
				}

			} catch (SQLException ssql) {
				System.out.println("ssql error : " + ssql);
			}

		return false;
	}

	public void intsertSQL(String id, String pw, String name, String nick) {
		try {
			String sql = "insert into CatchMine(ID, PW, NAME, NICK_NAME) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, nick);

			pstmt.executeUpdate(); // 쿼리 실행

			System.out.println("Insert 성공");

		} catch (SQLException e) {
			System.out.println("insert Error : " + e);
		} finally {
			disConnectSQL();
		}
	}

	public boolean SelectSQL(String str, int i) {
		try {
			pstmt = null;
			String selectSql = "select * from CatchMine";
			pstmt = conn.prepareStatement(selectSql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (str.equals(rs.getString(i))) {
					return false;
				}
			}
		} catch (SQLException ssql) {
			System.out.println("ssql error : " + ssql);
		}

		return true;
	}

	public void ConnectSQL() {
		try {
			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("연결 성공");
		} catch (SQLException ee) {
			System.out.println("Insert Connection Error : " + ee);
		}
	}

	public void disConnectSQL() {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException sqle) {
			} // PreparedStatement 객체 해제

		if (conn != null)
			try {
				conn.close();
				System.out.println("연결 종료");
			} catch (SQLException sqle) {
			} // Connection 해제
	}
}
