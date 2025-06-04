package utilities;


public class DataProviders {

	@org.testng.annotations.DataProvider(name="LoginData")
	public String [][] getData() throws Exception{
		
		 String path = System.getProperty("user.dir") + "/testdata/Book1.xlsx";
		
		ExcelUtility xutil=new ExcelUtility(path);
		
		int totalrow=xutil.getRowCount("Sheet4");
		int totalcols=xutil.getCellCount("Sheet4",0);
		
		String logindata[][] =new String[totalrow][totalcols];
		
		for (int i=1;i<= totalrow;i++) {
			
			for(int j=0;j < totalcols;j++) {
				
				logindata[i-1][j]=xutil.getCellData("Sheet4", i, j);
				
			}
		}
		
		
		return logindata;
		
	}
}
