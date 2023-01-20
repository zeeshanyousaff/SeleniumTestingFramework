package atf.config;

import org.aeonbits.owner.Config;

//used owner dependency to read data from config file. Implementation is easy data can be retrieved as per the required datatype.
// Rest of the implementation is in ConfigFactory class.
@Config.Sources(value = "file:${user.dir}/src/test/java/atf/configurations/config.properties")
public interface FrameworkConfig extends Config {
    String url();
}
