package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\datadriven.xlsx";  //taking xl file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object foe xlutility
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcols=xlutil.getCellCount("sheet1",1);
		
		String loginData[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)//1  //read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++)//0
			{
				loginData[i-1][j]=xlutil.getCellData("sheet1", i, j);//1,0
			}
		}
		return loginData;
	}
	////DataProvider2
	////DataProvider3
	////DataProvider4

}
