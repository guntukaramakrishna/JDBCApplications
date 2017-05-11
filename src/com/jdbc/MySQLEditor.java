package com.jdbc;

import java.sql.*;
public class MySQLEditor
{
	public static void main(String args[]) throws Exception
	{
		
		
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");

			System.out.println("Connected to DataBase......\n");

			Statement st = con.createStatement();

			java.util.Scanner sc = new java.util.Scanner(System.in);

			String query;

			System.out.print("MYSQL >");
			query = sc.nextLine();

			do{

				

				boolean flag = st.execute(query);


				if(flag)
				{

					// It has generated one resultset.
					ResultSet rs = st.getResultSet();


					System.out.println("BID\tBOOKNAME\tAUTHOR");
					System.out.println("------------------------------------------");
					while(rs.next())
					{

						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"       "+rs.getString(3));
					}

				}
				else
				{
					int count = st.getUpdateCount();

					System.out.println("\n"+count+" row(s) affected....");


				}


				System.out.print("\nMYSQL >");
				query = sc.nextLine();
			
			}while(!query.equals("exit"));

			con.close();
		}

			

}
