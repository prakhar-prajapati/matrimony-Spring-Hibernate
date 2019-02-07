package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.userBean;

public class MyDao {

	// Mysql Connection Code
		public Connection start() {
			Connection con = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root"); 
				} catch (Exception e) {
				System.out.println(e);
			}
			return con;
		}
		
//	
//	
//	
//	// insert data 
//	public int insert(userBean e) {
//			int y = 0;
//			try {
//				 Connection con=start();
//				 PreparedStatement ps = con.prepareStatement(
//"insert into user_details values(?,?,?,?,?,?,?,?,?,?)");
//			    ps.setString(1, e.getName());
//				ps.setString(2, e.getGender());
//				java.sql.Date sqlDate=new java.sql.Date(e.getDob().getTime());
//				ps.setDate(3, sqlDate);
//				ps.setString(4, e.getReligion());
//				ps.setString(5, e.getMother_tongue());
//				ps.setString(6, e.getCaste());
//				ps.setString(7, e.getCountry());
//				ps.setInt(8, e.getMobile());
//				ps.setString(9, e.getEmail());
//				ps.setString(10, e.getPassword());
//
//				y = ps.executeUpdate();
//				con.close();
//			} catch (Exception w) {
//				System.out.println(w);
//			}
//			return y;
//		}
//

//	//user login
//	public int loginCheck(String email , String password)	 
//	{
//		int x=0;
//	try {
//			Connection con =start(); 
//			PreparedStatement ps = con.prepareStatement("Select * from user_details where email=? and password=?");
//			ps.setString(1, email);
//			ps.setString(2, password);
//			ResultSet rs=ps.executeQuery();
//            System.out.println(ps); 
//			x=0;
//			if(rs.next())
//           x=1;
//	}catch(Exception e)
//		{
//		System.out.println(e);
//		}
//		return x;
//	}

	
	// Display 
		public ArrayList<userBean> ShowData(String gender) {
			ArrayList<userBean> list = new ArrayList<>();
			try {
				Connection con = start();
				PreparedStatement ps = con.prepareStatement("select * from user_details where gender!=?");
                ps.setString(1, gender);
				ResultSet rs = ps.executeQuery();
				while (rs.next())
				{
					userBean o = new userBean();
					o.setName(rs.getString("name"));
					o.setGender(rs.getString("gender"));
					o.setDob(rs.getDate("DOB"));
					o.setReligion(rs.getString("religion"));
					o.setMother_tongue(rs.getString("mother_tongue"));
					o.setCaste(rs.getString("caste"));
					o.setCountry(rs.getString("country"));
					o.setMobile(rs.getInt("mobile"));
					list.add(o);

				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(list);
			return list;
		}

	
		//get gender from email id
		public String getGender(String email) {
			String gender = null;
      	try {
      			Connection con = start();
				PreparedStatement ps = con.prepareStatement("Select gender from user_details where email=?");
				ps.setString(1,email);
				System.out.println("send gender  dao call");
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
				gender=rs.getString(1);
				}
					con.close();
			} catch (SQLException w) {
				System.out.println(w);
			}
			return gender;
		}

/////////////----------------------------------------------
	//Hibernate code
		
		public int Insert( Object eb)
	{int x=0; 
		Object o;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();
		o=ss.save(eb);
		if(o!=null)
			x=1;
		tt.commit();
		ss.close();
		return x;
	}

//		user login
		public int loginCheck(String email , String password)	 
		{ int x;
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			//Transaction tt=ss.beginTransaction();
			Criteria ct=ss.createCriteria(userBean.class);
			ct.add(Restrictions.eq("email", email));
			ct.add(Restrictions.eq("password",password));
			ArrayList<userBean> list=(ArrayList<userBean>)ct.list();
			if(list.isEmpty())
				x=0;
			else
				x=1;
            			
		//	tt.commit();
			ss.close();
			return x;
		}
}
