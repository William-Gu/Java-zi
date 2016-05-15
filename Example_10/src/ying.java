import java.sql.*;

public class ying {
	public void init(){
		Connection con;
		if((con=connectByJdbcOdbc("qdm11441097.my3w.com","qdm11441097","guanjun150"))!=null){
			System.out.println("OK");
		}else{
			System.out.println("Error");
		}
	}
	public Connection connectByJdbcOdbc(String url,String user,String psw){
		Connection con=null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}catch(Exception e){
			System.out.println("Connect Error.");
			e.printStackTrace();
			return null;
		}
		try{
			con=DriverManager.getConnection(url,user,psw);
		}catch(SQLException e){
			System.out.println("Connect SQL Error.");
			e.printStackTrace();
			return null;
		}
		return con;
	}
}
