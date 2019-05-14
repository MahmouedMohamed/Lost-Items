

import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.*;

public class PersonDataaccess{
	private Connection con;
	private Statement st;
	private ResultSet rs;
    public PersonDataaccess()
    {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","x"/*UserName*/,"x"/*PassWord*/);
    		st=con.createStatement();
    	}
    	catch(Exception ex)
    	{
    		System.out.print("S"+ex);
    	}
    }
    public void getdata(Object object,Person P)
	{	    	
		PersonDataaccess Access=new PersonDataaccess();
		try
		{
			String query="SELECT * FROM `persons` WHERE NID ="+""+object+"";
			rs= st.executeQuery(query);
			while(rs.next())
			{
				P.Setname(rs.getNString(1));
				P.SetEmail(rs.getNString(2));
				P.SetPass(rs.getNString(3));
				P.SetNID(rs.getInt(4));
				P.SetPhoneN(rs.getInt(5));
				P.SetRate(rs.getFloat(6));
				P.SetPic(rs.getBytes(7));
			}
		}
		catch(Exception ex)
		{
			
		}
	}
    public boolean Validation(int ID)
    {
    	PersonDataaccess Access=new PersonDataaccess();
    	try {
    		String query="SELECT * FROM `persons` WHERE `NID` = "+ID;
    		rs=st.executeQuery(query);
    		if(!rs.isBeforeFirst()) {
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    		
    	}
    	catch(Exception ex)
    	{
    		return true;
    	}
    }
    public void add(Person P)
    {	
    	PersonDataaccess Access=new PersonDataaccess();
    	try
    	{	
    		String query = " insert into persons (name, Email, Pass, NID, PhoneNumber, Rate, pic)"
    		        + " values (?, ?, ?, ?, ?,?,?)";
    		PreparedStatement preparedStmt = con.prepareStatement(query);
    	      preparedStmt.setString (1, P.getname());
    	      preparedStmt.setString (2, P.getEmail());
    	      preparedStmt.setString (3, P.getPass());
    	      preparedStmt.setInt(4, (int) P.getNID());
    	      preparedStmt.setInt(5, (int) P.getPhoneN());
    	      preparedStmt.setFloat(6, P.getRate());
    	      preparedStmt.setBytes(7, P.getPic());
    	      preparedStmt.execute();
    	}catch(Exception Ex)
    	{
    		System.err.println("Got an exception!");
    	      System.err.println(Ex.getMessage());
    	}
    }
    public boolean Validation(int ID,String Pass,Person P)
    {
    	PersonDataaccess Access=new PersonDataaccess();
    	try
    	{
    		String query="SELECT * FROM `persons` WHERE `Pass` = "+"'"+Pass+"'"+" AND `NID` = "+ID;
    		rs= st.executeQuery(query);
    		if (!rs.isBeforeFirst() ) { 
    		    return false;
    		} 
    		while(rs.next())
			{
				P.Setname(rs.getNString(1));
				P.SetEmail(rs.getNString(2));
				P.SetPass(rs.getNString(3));
				P.SetNID(rs.getInt(4));
				P.SetPhoneN(rs.getInt(5));
				P.SetRate(rs.getFloat(6));
				P.SetPic(rs.getBytes("pic"));
			}
    		return true;
    	}
    	catch(Exception ex)
    	{
    		return false;
    	}
    }
}
