package com.example.demo.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Bookings.BookTravel;
import com.example.demo.Registrations.User;
import com.example.demo.SIGNUP.Signup;

@Repository
public class MyRepo {
	
//INSERTION:
public BookTravel insertBooking(BookTravel bookTravel) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hello";
		Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
		
		String query="insert into hello.bookingtable(fromDestination,toDestination,price,date) value(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString (1, bookTravel.getFromDestination());
		pst.setString (2,bookTravel.getToDestination());
		pst.setString (3,bookTravel.getPrice());
		pst.setString (4,bookTravel.getDate());
		
		
		if(pst.executeUpdate()>0)
			return bookTravel;
		return null;
	}


//GetALLData:
public List<BookTravel> getAllBookings() throws ClassNotFoundException, SQLException {
	
	String url = "jdbc:mysql://localhost:3306/hello";
	List<BookTravel> list = new ArrayList<BookTravel>();
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
	
	Statement st=con.createStatement();
	
	String query="Select DISTINCT * from hello.bookingtable";
	ResultSet rs=st.executeQuery(query);
	
	while(rs.next()) {
		
		BookTravel bookTravel = new BookTravel();
		
		bookTravel.setId(rs.getInt(1));
		bookTravel.setFromDestination(rs.getString(2));
		bookTravel.setToDestination(rs.getString(3));
		bookTravel.setPrice(rs.getString(4));
		bookTravel.setDate(rs.getString(5));
		
		list.add(bookTravel);
	}
	return list;
}

//UPDATION:
public String updateBooking(BookTravel bookTravel) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/hello";
	Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
	
	String query="Update hello.bookingtable set fromDestination=?, toDestination=? where id=? ";
	
	PreparedStatement pst=con.prepareStatement(query);
	pst.setString(1, bookTravel.getFromDestination());
	pst.setString (2,bookTravel.getToDestination());
	pst.setInt (3,bookTravel.getId());
	
	if(pst.executeUpdate()>0) {
		return "Updated Sucesfully";
	}
	else
	return "update not sucessfull";
}

//DELETION:
public String deleteBooking(int id) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/hello";
	Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
	
	String query="Delete from  hello.bookingtable  where id=?";
	PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, id);
		
	if(pst.executeUpdate()>0) {
		return "record deleted sucessfully";
	}
	else
	return "could not delete record";
}




//Signup:
public Signup insertUser(Signup signup) throws SQLException, ClassNotFoundException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/hello";
	Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
     
	String q="INSERT INTO SIGNUP VALUES(?,?,?)";
	
		PreparedStatement pst=con.prepareStatement (q);
		pst.setInt(1,signup.getId());
		pst.setString(2,signup.getEmail());
		pst.setString(3,signup.getPassword());


	pst.executeUpdate();
	return signup;

}


//Checkuser:
public String checkUser(String email, String password) throws SQLException, ClassNotFoundException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		String url = "jdbc:mysql://localhost:3306/hello";
		Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
         
		String q="SELECT * FROM SIGNUP WHERE EMAIL=? AND PASSWORD=?";
     
     PreparedStatement pst=con.prepareStatement (q);
       pst.setString(1, email);
       pst.setString(2, password);
       
    ResultSet rs=pst.executeQuery();
   if(rs.next()) {

     return "WELOME USER HAVAE A GREAT DAY";

    }
else {
	
	try {
		throw new UserNotFoundException("USER IS NOT REGISTERED");
	}
	catch (UserNotFoundException u) {
		
	       return "PLEASE ENTER VALID USERNAME OR PASSWORD";
	}
  }


 }




//CURRRENTLY WE ELIMINATED THESE CLASS.

//public User insert(User user) throws ClassNotFoundException, SQLException {
//
//Class.forName("com.mysql.cj.jdbc.Driver");
//String url = "jdbc:mysql://localhost:3306/hello";
//Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
//
//String query="insert into hello.users(fname,lname,email,phone,pwd,cpwd,gender) value(?,?,?,?,?,?,?)";
//PreparedStatement pst=con.prepareStatement(query);
//pst.setString(1, user.getfName());
//pst.setString (2,user.getlName());
//pst.setString (3,user.getEmail());
//pst.setLong (4,user.getPhone());
//pst.setString (5,user.getPassword());
//pst.setString(6, user.getcPass());;
//pst.setString (7,user.getGender());
//
//if(pst.executeUpdate()>0)
//	return user;
//return null;
//}


}

 class UserNotFoundException extends Exception{
	
	public  UserNotFoundException(String msg) {
		super(msg);
	}
}

