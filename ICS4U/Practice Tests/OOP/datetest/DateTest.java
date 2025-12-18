
import java.util.*;

public class DateTest {

    public static void main(String[] args) {
		MyDate d1 = new MyDate("January 12 2017");
		MyDate d2 = new MyDate("10 2 2020");
		System.out.println(d1.between(d2));
		System.out.println(d1);
		System.out.println(d2);
    }
}

/*
1358
January 12 2017
October 2 2020
*/