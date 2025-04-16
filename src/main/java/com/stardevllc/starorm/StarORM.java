package com.stardevllc.starorm;

import com.stardevllc.starorm.converters.impl.*;
import com.stardevllc.starorm.interfaces.ObjectConverter;
import com.stardevllc.starorm.model.DatabaseRegistry;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public final class StarORM {
    private static Logger logger = createLogger();

    public static final Set<ObjectConverter> DEFAULT_TYPE_HANDLERS = Set.of(new BooleanConverter(), new DoubleConverter(), new EnumConverter(), new FloatConverter(), new IntegerConverter(), new LongConverter(), new StringConverter(), new UUIDConverter());

    public static DatabaseRegistry createDatabaseRegistry() {
        return new DatabaseRegistry(logger);
    }

    public static void setLogger(Logger logger) {
        StarORM.logger = logger;
    }

    public static Logger getLogger() {
        return logger;
    }

    private static Logger createLogger() {
        Logger logger = Logger.getLogger(StarORM.class.getName());
        logger.setUseParentHandlers(false);
        logger.addHandler(new StreamHandler(System.out, new Formatter(StarORM.class.getName())));
        return logger;
    }

    public static class Formatter extends SimpleFormatter {

        private String name;

        public Formatter(String name) {
            this.name = name;
        }

        @Override
        public String format(LogRecord record) {
            Instant instant = record.getInstant();
            LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            return time.getMonthValue() + "/" + time.getDayOfMonth() + "/" + time.getYear() + " " +
                    time.getHour() + ":" + time.getMinute() + ":" + time.getSecond()
                    + " " + record.getLevel().getName() +
                    " [" + name + "] " + record.getMessage() + "\n";
        }
    }
}