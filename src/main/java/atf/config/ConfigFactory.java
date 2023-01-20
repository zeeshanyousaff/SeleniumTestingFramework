package atf.config;

public class ConfigFactory {

    public static FrameworkConfig getConfig()
    {
        FrameworkConfig config = org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);
        return config;
    }
}
