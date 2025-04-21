/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: BrowserNotSupportedException.java
 * Author: David Davis
 * Date: March 19, 2025
 * I know this is not part of the requirements but I wanted to create a custom exception to see how to do this in java.
 * Guess what, it's the same in .net.
 */
package Core;

public class BrowserNotSupportedException extends RuntimeException{
    public BrowserNotSupportedException() {
        super();
    }

    public BrowserNotSupportedException(String message) {
        super(message);
    }

    public BrowserNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrowserNotSupportedException(Throwable cause) {
        super(cause);
    }
}