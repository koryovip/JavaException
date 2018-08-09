package ex;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        final Controller aaaaa = new Controller();
        try {
            aaaaa.check(1);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        try {
            aaaaa.check(2);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        try {
            aaaaa.check(3);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public void check(int value) throws Exception {
        if (value == 1) {
            throw logger.throwing(Level.WARN, BL001Exceptions.E002("USER-001"));
        }
        if (value == 2) {
            throw logger.throwing(BL001Exceptions.E002(null));
        }
        if (value == 3) {
            throw logger.throwing(BL001Exceptions.E003("T_USER_INFO", "101", "user_009"));
        }
        logger.debug("END");
    }
}
