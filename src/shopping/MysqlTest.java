package shopping;

import java.sql.*;

public class MysqlTest {
	String JDriver = "com.mysql.jdbc.Driver"; // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见
	String conURL = "jdbc:mysql://localhost:3306/3Q_training"; // 本地计算机上的MySQL数据库Company的URL

	public void Mysql() {
		try {
			Class.forName(JDriver);
			Connection con = DriverManager.getConnection(conURL, "root",
					"123456"); // 连接数据库
			Statement s = con.createStatement(); // Statement类用来提交SQL语句
			ResultSet rs = s.executeQuery("select * from t_goods;"); // 提交查询，返回的表格保存在rs中
			while (rs.next()) { // ResultSet指针指向下一个“行”
				System.out.println(rs.getInt("Id") + "\t"
						+ rs.getString("goods_name"));
			}
			
			rs.close();
			s.close();// 释放Statement对象
			con.close(); // 关闭到MySQL服务器的连接
		} catch (ClassNotFoundException cnf_e) { // 如果找不到驱动类
			System.out.println("Driver Not Found: " + cnf_e);
		} catch (SQLException sql_e) { // 都是SQLException
			System.out.println(sql_e);
		}
	}

	public static void main(String[] args) {
		MysqlTest t = new MysqlTest();
		t.Mysql();
	}
}
