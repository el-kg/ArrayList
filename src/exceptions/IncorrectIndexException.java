package exceptions;

public class IncorrectIndexException extends IndexOutOfBoundsException{
    public IncorrectIndexException(String s) {
        super(s);
    }
}
