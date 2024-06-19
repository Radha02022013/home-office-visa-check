package resources.testdata;

import org.testng.annotations.DataProvider;


public class TestData {
    @DataProvider(name = "AustralianComingToUk")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Australia","Tourism"},
                {"Chile","Work, academic visit or business"},
                {"Colombia","Join partner or family for a long stay" },
                {"Finance","London"},
                {"business Analyst"},
                {"Java Developer"},
        };
        return data;
    }

    @DataProvider(name = "AustralianComingToUk")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Australia","Tourism"},
                {"Chile","Work, academic visit or business"},
                {"Colombia","Join partner or family for a long stay" },
                {"Finance","London"},
                {"business Analyst"},
                {"Java Developer"},
        };
        return data;
    }

}
