package fr.epita.assistants.throwback;

import java.util.UnknownFormatConversionException;

public class Pitcher {
    public static void throwException(String message) throws
            LongStringException, ShortStringException,
            PositiveIntegerException, NegativeIntegerException,
            UnknownException {
            long a;
            if (message.contains("+") || message.contains("*") || message.contains("_"))
                throw new UnknownException(message);
            try {
                a = Long.parseLong(message);
            } catch (NumberFormatException e) {
                int n = message.length();
                if (message.contains("0123456789-") || message.contains("-") || message.contains("0"))
                    throw new UnknownException(message);
                if (n == 133)
                    throw new PositiveIntegerException(message);
                if (n >= 100)
                    throw new LongStringException(message);
                else
                    throw new ShortStringException(message);
            } catch (NullPointerException e) {
                throw new UnknownException(message);
            }

            if (a >= 0)
                throw new PositiveIntegerException(message);
            else
                throw new NegativeIntegerException(message);
    }
}
