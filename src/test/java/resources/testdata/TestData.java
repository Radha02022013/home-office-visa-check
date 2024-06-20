package resources.testdata;

import org.testng.annotations.DataProvider;


public class TestData {
    @DataProvider(name = "AustralianComingToUk")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Australia","Tourism"},
        };
        return data;
    }

    @DataProvider(name = "Chile")
    public Object[][] getData1(){
        Object[][] data = new Object[][]{
                {"Chile","Work academic visit or business","Health and care professional"},
        };
        return data;
    }

    @DataProvider(name = "Colombia")
    public Object[][] getData2(){
        Object[][] data = new Object[][]{
                {"Colombia","Join partner or family for a long stay" },
        };
        return data;
    }

}
