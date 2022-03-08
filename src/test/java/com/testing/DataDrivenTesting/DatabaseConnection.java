package com.testing.DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;




public class DatabaseConnection {

	@Test(dataProvider="DP1")
	//	public void test1(String u1,String u2,String u3,String u4,String u5,String u6)
	public void test1(String u1)
	{
		System.out.println(u1);
	}

	@DataProvider(name="DP1")
	public String[] feedData() throws Throwable
	{
		String[] data=new String[2];
		data[0]="hai";

		data[1]="girl";
		//String[][] data=getData();
		return data;
	}

	public String[][] getData() throws Throwable
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/basic","root","Mysql@4608");
		System.out.print("Connection Established ...");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String query1="select * from student";
		ResultSet rs=stmt.executeQuery(query1);
		System.out.print("Query Executed Successfully");
		ResultSetMetaData metaData=rs.getMetaData();
		int cols=metaData.getColumnCount();
		System.out.println("Number of columns : "+ cols);
		rs.last();
		int rows=rs.getRow();
		rs.beforeFirst();
		String[][] data=new String[rows][cols];
		int r=0;
		while(rs.next())
		{

			System.out.println("");
			for(int i=0;i<cols;i++)
			{
				data[r][i]=rs.getString(i+1);
				//System.out.print(rs.getString(i)+"  ");


			}
			r++;
		}

		for(int x=0;x<rows;x++)
		{
			System.out.println("");
			for(int y=0;y<cols;y++)
			{
				System.out.print(data[x][y]+"  ");
			}
		}
		System.out.println("===============================================");

		return data;
	}

}
