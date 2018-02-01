package item1;

import sun.security.tools.keytool.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.*;

/**
 * Item 1: Consider static factory methods instead of constructors
 */
public class StaticFactory {

    /**
     * One advantage of static factory methods is that, unlike constructors,
     * they have names.
     * (page 5)
     */
    public static BigInteger probablePrime(){
        return BigInteger.probablePrime(10, new Random());
    }


    /**
     * A second advantage of static factory methods is that, unlike constructors,
     * they are not required to create a new object each time they’re invoked
     * (page 6)
     */
    private static final Boolean TRUE = new Boolean(true);
    private static final Boolean FALSE = new Boolean(false);
    public static Boolean valueOf(boolean val){
        return val  ? TRUE : FALSE;
    }


    /**
     * A third advantage of static factory methods is that, unlike constructors,
     * they can return an object of any subtype of their return type.
     * (page 6)
     */
    public static Object getCollection(){
        return new ArrayList();
    }


    /**
     * A fourth advantage of static factories is that the class of the returned
     * object can vary from call to call as a function of the input parameters
     * (page 7)
     */
    public static List getListByParam(int param){
        int constant = 100;
        if (param > constant) {
            return new ArrayList();
        }else {
            return new LinkedList();
        }
    }


    /**
     * A fifth advantage of static factories is that the class of the returned object
     * need not exist when the class containing the method is written.
     * (page 8)
     */
    public static void exampleFifthAdvantage() throws Exception{
        Driver driver = null;
        String url = "jdbcUrl";
        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(url);
    }

    /**
     * Common naming conventions
     * (page 9)
     */
    public static void commonNamingConversation() throws Exception{
        /**
         * from - A type-conversion method that takes a single parameter and return
         * corresponding instance of this type
         */
        Date d = Date.from(Calendar.getInstance().toInstant());

        /**
         * of — An aggregation method that takes multiple parameters and returns an
         * instance of this type that incorporates them
         */
        Set<Numbers> faceCards = EnumSet.of(Numbers.ONE, Numbers.TWO);

        /**
         * valueOf — A more verbose alternative to from and of
         */
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);

        /**
         * instance or getInstance — Returns an instance that is described by its
         * parameters (if any) but cannot be said to have the same value
         */
        StackWalker luke = StackWalker.getInstance(EnumSet.of(StackWalker.Option.SHOW_HIDDEN_FRAMES));

        /**
         * create or newInstance — Like instance or getInstance , except that the
         * method guarantees that each call returns a new instance
         */
        Object newArray = Array.newInstance(Integer.class, 14);

        /**
         * get Type — Like getInstance , but used if the factory method is in a different class.
         * Type is the type of object returned by the factory method
         */
        FileStore fs = Files.getFileStore(Paths.get("paths"));

        /**
         * new Type — Like newInstance, but used if the factory method is in a different
         * class. Type is the type of object returned by the factory method
         */
        BufferedReader br = Files.newBufferedReader(Paths.get("paths"));

        /**
         * type — A concise alternative to get Type and new Type
         */
        List<String> litany = Collections.list(new Vector<String>().elements());
    }

    enum Numbers{ONE, TWO, THREE, FOUR, FIVE};
}
