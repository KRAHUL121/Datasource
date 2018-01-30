import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
 @WebServlet("/registration") 
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  


    // Set dataSource Properties
    
    Connection conn = null;
    ResultSet rs = null;
          
try{  
    conn = getMysqlDataSource().getConnection();
    PreparedStatement ps=conn.prepareStatement( "insert into registeruser ( `name`, `password`) values(?,?)");  
   
ps.setString(1,n);  
ps.setString(2,p);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}

private MysqlDataSource getMysqlDataSource() {
    MysqlDataSource dataSource = new MysqlDataSource();
    dataSource.setServerName("localhost");
    dataSource.setPortNumber(3306);
    dataSource.setDatabaseName("datasource");
    dataSource.setUser("root");
    dataSource.setPassword("");
	return dataSource;
}  
  
}  