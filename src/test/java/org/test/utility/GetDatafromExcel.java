package org.test.utility;

import java.util.ArrayList;

import org.excel.utitlity.Xls_Reader;


public class GetDatafromExcel {
	
	static Xls_Reader reader;
public static ArrayList<Object[]> getdatafromexcel() {
ArrayList<Object[]>mydata=new ArrayList<Object[]>();
try {
	 reader=new Xls_Reader("C:\\Users\\jegan\\eclipse-workspace\\TestNgtoWebsite\\src\\test\\java\\org\\Excelfile\\siva1.xlsx");
	}catch(Exception e) {
		e.printStackTrace();
	}
for(int rowNum=2;rowNum<=reader.getRowCount("Details");rowNum++ ) {
String firstname = reader.getCellData("Details", "Firstname", rowNum);
String lastname = reader.getCellData("Details", "Lastname", rowNum);
String emailaddress = reader.getCellData("Details", "Emailaddress", rowNum);

Object[] ob= {firstname,lastname,emailaddress};

mydata.add(ob);

}
return mydata;
}
}