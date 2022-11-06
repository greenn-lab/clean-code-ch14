import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler implements ArgumentMarshaler {

    private String stringValue = null;

    public static String getValue(ArgumentMarshaler am) {
        if (am instanceof StringArgumentMarshaler stringArgumentMarshaler) {
            return stringArgumentMarshaler.stringValue;
        } else {
            return "";
        }
    }

    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_STRING);
        }
    }

}
