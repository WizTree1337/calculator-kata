package calculator;

public class ThrowsException extends Exception {
    String msg;

    ThrowsException(String str){
        msg = str;
    }

    public String toString() {
        return ("throws Exception //" + msg);
    }
}
