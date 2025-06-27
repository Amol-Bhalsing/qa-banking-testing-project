package utilities;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
    @DataProvider(name = "loginData")
    public Object[][] getLoginTestData() {
        String path = System.getProperty("user.dir") + "/src/test/resources/testData/LoginData.xlsx";
        return ExcelUtils.getData(path, "Sheet1");
    }

}
