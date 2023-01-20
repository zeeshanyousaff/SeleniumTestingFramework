package atf.config.obselete;

import atf.constants.FrameworkConstants;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

//don't want others to extend this class unless required, therefore, making the class final.

public final class ReadPropertyFile {
    //don't want  others to create object of this class unless required therefore, making a private constructor.
    private ReadPropertyFile() {
    }

    private static Properties property = new Properties();

    /*A static block, or static initialization block, is code that is run once for each time a class is loaded into memory.
    It is useful for setting up static variables or logging, which would then apply to every instance of the class.
     */
    static {
        //another way to fetch data is to load into a hashmap and then retrieve from it.
        // Although little slower but it is thread safe. See testing mini bytes video.
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String key) throws Exception {
        //problem with this way of loading the file inside the getValue method that for every call to this getValue method, whole file will be loaded again and again.
        //To avoid this problem, we can use static block that is run once for each time a class is loaded into memory. Check above.

//        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/configurations/config.properties");
//        prop.load(fis);
        //checking incase the key or the value is null.
        if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("Property name: {" + key + "} not found. Please check config.properties.");
        }

        return property.getProperty(key);
    }
}
