package May2026.LLD.Day2.singleton;

import java.io.Serial;
import java.io.Serializable;

public class Logger implements Serializable {
    private static volatile Logger instance;

    private Logger() {
        if (instance != null) {
            throw new RuntimeException("use getInstance()");
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    @Serial
    public Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("not supported");
    }
}
