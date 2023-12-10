package mysqljdbc;
import java.sql.*;
import java.util.*;


public class Mysqljdbc {

    
    public static void main(String[] args) throws Exception {
        
        Scanner ine=new Scanner(System.in);
        
        
        int ch;
        do{
        
            
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.UPDATE");
            System.out.println("4.DELETE");
            System.out.print("Enter Your Choice : ");
            ch=ine.nextInt();
            
            switch(ch)
            {
                case 1:
                insertUsingpst();  
                    
                break;
                
                case 2:
                readRecodrs();    
                break;
                
                
                case 3:
                    updateS();
                    break;
                    
                case 4:
                    deleteS();
                    break;
                    
                    
                default:
                    System.out.println("Wring input....!");
                    
                    
            }
        
        
        }while(ch!=0);
          
    
    
    
    }
    public static void readRecodrs() throws Exception
    {
    
        
        
        String url="jdbc:mysql://localhost:3306/tutorial?characterEncoding=latin1";
        String userName="root";
        String passWord="Muthur@su22";
        String query="Select * from student";
        
        
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userName,passWord);
        
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        
        
        while(rs.next())
             System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getInt(4)+"\t "+rs.getInt(5));
            
        con.close();
              
    }
    public static void insertRecord() throws Exception
    {
        
        String url="jdbc:mysql://localhost:3306/tutorial?characterEncoding=latin1";
        String userName="root";
        String passWord="Muthur@su22";
        String query="insert into student values(15,'ram','eee',5,88)";
    
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userName,passWord);
        
        Statement stmt=con.createStatement();
        int rows =stmt.executeUpdate(query);
        
        
        System.out.println("Number of rows affected :"+rows);
        con.close();
              
    }
    public static void insertUsingpst() throws Exception
    {
        
        Scanner ine=new Scanner(System.in);
        Scanner st=new Scanner(System.in);
        
        System.out.println("Enter a STUDEND roll No :");
        int rollno=ine.nextInt();
        System.out.println("Enter a name :");
        String name=st.nextLine();
        System.out.println("Enter a department :");
        String dept=st.nextLine();
        System.out.println("Enter a year :");
        int year=ine.nextInt();
        System.out.println("Enter a total mark :");
        int mark=ine.nextInt();
        
        String url="jdbc:mysql://localhost:3306/tutorial?characterEncoding=latin1";
        String userName="root";
        String passWord="Muthur@su22";
        String query="insert into student values(?,?,?,?,?)";
        
        
      
    
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userName,passWord);
        
        
        
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,rollno);
        pst.setString(2, name);
        pst.setString(3,dept);
        pst.setInt(4,year);
        pst.setInt(5, mark);
        int rows=pst.executeUpdate();
        
        System.out.println("Number of rows affected :"+rows);
        
        con.close();
              
    }
    public static void insertVar() throws Exception
    {
        
        int rollno=49;
        String name="abi";
        String dept="cse";
        int year=18;
        int mark=84;
        
        String url="jdbc:mysql://localhost:3306/tutorial?characterEncoding=latin1";
        String userName="root";
        String passWord="Muthur@su22";
        String query="insert into student values("+rollno+",'"+name+"','"+dept+"',"+year+","+mark+");";
       
        
        
      
    
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userName,passWord);
        
        
        
        Statement st=con.createStatement();
        int rows=st.executeUpdate(query);
        
        System.out.println("Number of rows affected :"+rows);
        
        con.close();
              
    }
    public static void deleteS() throws Exception
    {
        Scanner ine=new Scanner(System.in);
        System.out.println("Enter a rollNo for delete :");
        int rollno=ine.nextInt();
        
        
        String url="jdbc:mysql://localhost:3306/tutorial?characterEncoding=latin1";
        String userName="root";
        String passWord="Muthur@su22";
        String query="delete from student where rollno = "+rollno;
       
        
        
      
    
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userName,passWord);
        
        
        
        Statement st=con.createStatement();
        int rows=st.executeUpdate(query);
        
        System.out.println("Number of rows affected :"+rows);
        
        con.close();
              
    }
    public static void updateS() throws Exception
    {
        
        Scanner ine=new Scanner(System.in);
        System.out.println("Enter year change details :");
        int year=ine.nextInt();
        System.out.println("where is roll no change year :");
        int rollno=ine.nextInt();
        
        
        String url="jdbc:mysql://localhost:3306/tutorial?characterEncoding=latin1";
        String userName="root";
        String passWord="Muthur@su22";
        String query="update student set year=? where rollno=?";
        
        
        
       
        
        
      
    
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userName,passWord);
        
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,year);
        pst.setInt(2,rollno);
        
        
        
        //Statement st=con.createStatement();
        int rows=pst.executeUpdate();
        
        System.out.println("Number of rows affected :"+rows);
        
        
        
        
        
        con.close();
              
    }
    //create
    //prepate
    //callabel statement
    //call simple procedure
    
}
