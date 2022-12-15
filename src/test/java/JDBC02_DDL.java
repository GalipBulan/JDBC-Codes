import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02_DDL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        /*
    A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
       dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.
        1) execute() metodu
        2) executeUpdate() metodu.
    B) - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
       - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken,
         DML islemlerinde true deger dondurur.
       - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
         durumlarda tercih edilmektedir.
    C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
       - bu islemlerde islemden etkilenen satir sayisini dondurur.
       - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.

         */

        /*=======================================================================
          ORNEK1:isciler tablosunu siliniz
        ========================================================================*/

        //Class.forName("com.mysql.cj.jdbc.Driver");

       // Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        //Statement st= con.createStatement();

        //String dropTbale = "DROP TABLE isciler";

        //if (!st.execute(dropTbale))
           // System.out.println("Isciler tablosu silindi");

        //else
           // System.out.println("Isciler tablosu silinmedi");

        /*=======================================================================
	  ORNEK2:isciler adinda bir tablo olusturunuz id int,
	  birim VARCHAR(10), maas int
	    ========================================================================*/

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        Statement st1= con1.createStatement();

        String creatTbale = "CREATE TABLE isciler (in INT, birim VARCHAR(10), maas INT";

        st1.execute(creatTbale);

        if (!st1.execute(creatTbale))
        System.out.println("Isciler tablosu create edildi");

        else
        System.out.println("Isciler tablosu basari ile create edilemedi");


    }
}
