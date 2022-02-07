package learnings;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "credentials")
    public Object[][] getData() {

        return new Object[][]{{"admin", "admin123"}
                              };

    }
}
