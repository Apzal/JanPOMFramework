package DataProviders;

import org.testng.annotations.DataProvider;

public class CustomData {

    @DataProvider(name = "login")
    public Object[][] getLoginData(){
        return new Object[][]{{"admin","admin123"}};
    }
}
