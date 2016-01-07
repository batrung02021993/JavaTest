import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CheckLogin {
	public static ArrayList<User> checkPhone(String phone) throws SQLException,
			ClassNotFoundException {
		ArrayList<User> list = new ArrayList<User>();
		String database = "dbsocnet";
		String userName = "sa";
		String password = "11130030";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionURL = "jdbc:sqlserver://" + ";databaseName="
				+ database;

		Connection conn = DriverManager.getConnection(connectionURL, userName,
				password);
		String sql = "select * from [USER] where [PHONE] = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, phone);
		ResultSet rs = pre.executeQuery();
		while(rs.next()){
			String user= rs.getString("USERNAME");
			String pass = rs.getString("PASSWORD");
			String birth = rs.getString("BIRTHDAY");
			String gender = rs.getString("GENDER");
			String email = rs.getString("EMAIL");
			String phones = rs.getString("PHONE");
			String address = rs.getString("ADDRESS");
			String avatar = rs.getString("AVARTAR_IMAGE");
			String cover = rs.getString("COVER_IMAGE");
			User users = new User(user, pass, birth, gender, email, phones, address, avatar, cover);
			list.add(users);
		}
		return list;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(checkPhone("0977405203"));
	}
}
