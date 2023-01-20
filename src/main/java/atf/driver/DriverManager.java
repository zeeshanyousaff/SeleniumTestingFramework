package atf.driver;

import org.openqa.selenium.WebDriver;

//don't want others to extend this class, therefore, making it final.
public final class DriverManager {

    //don't want  others to create object of this class therefore, making a private constructor.
    private DriverManager() {
    }

    /*
    Thread local class has been used to handle the thread safety issue in parallel test execution.
    Previously, without thread local class, if test cases were executed parallelly, then staleElement exception used to appear.
    To handle that issue, thread local class helps in managing driver initialization for each thread making it possible for each thread complete
    its execution.  */


    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    //getDriver method will get the initialized driver and use it for execution.
    public static WebDriver getDriver() {
        return dr.get();
    }

    //setDriver of thread local class takes driver parameter and sets the driver for initialization.
    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    //Once the thread local class is used, it is very important to clean up the active thread to avoid execution issues and memory leaks etc.
    public static void unload() {
        dr.remove();
    }

}

/*
* This is a utility class that is used to manage a WebDriver instance for each thread.
* It has a ThreadLocal field called dr, which stores a WebDriver instance that is specific to the current thread.
The class has a private constructor, which prevents other classes from creating an instance of this class. It also has three public methods:

getDriver(): This method returns the WebDriver instance that is associated with the current thread.
setDriver(WebDriver driverref): This method sets the WebDriver instance that is associated with the current thread.
unload(): This method removes the WebDriver instance that is associated with the current thread. This is important to avoid execution issues and memory leaks.

The use of a ThreadLocal field allows multiple threads to use the same DriverManager class concurrently, without interfering with each other.
This can be useful when running tests in parallel, as each thread can have its own WebDriver instance.

* */