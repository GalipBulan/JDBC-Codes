import java.sql.*;

public class JDBC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        // 1- ilgili driver`i yuklemeliyiz Mysql kullandigimizi soylucez

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2- Baglantiyi olusturmak icin
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3.- SQL query`leri icin bir satatment obj olusturup javada kendimize sql surgulari icin alan acacagiz

        Statement st= con.createStatement();

        // 4- SQL sorgularini yazip, calistirabiliriz..

        /*
        CREATE TABLE calisanlar(
		id INT PRIMARY KEY,
		isim VARCHAR(50),
		sehir VARCHAR(50),
		maas INT,
		sirket VARCHAR(20)

         */

        ResultSet data= st.executeQuery("SELECT * FROM calisanlar");



        while (data.next()){
            System.out.println(data.getInt("id")+" "+ data.getString("isim")+ " "+data.getString("sehir")+" "+data.getInt("maas")
                    +" "+ data.getString("sirket"));
        }
        data.close();
        st.close();
        con.close();



    }
}
