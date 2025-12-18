
import java.util.HashMap;

class MyDate {

    HashMap<String, Integer> months_to_int = new HashMap<String, Integer>(){{
        put("JANUARY", 1); put("FEBRUARY", 2); put("MARCH", 3); put("APRIL", 4); put("MAY", 5); put("JUNE", 6);
        put("JULY", 7); put("AUGUST", 8); put("SEPTEMBER", 9); put("OCTOBER", 10); put("NOVEMBER", 11); put("DECEMBER", 12);
    }};

    String[] int_to_months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    int[] month_to_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int month, day, year;

    public MyDate(String data) {
        String[] data2 = data.split(" ");
        try {
            month = months_to_int.get(data2[0].toUpperCase());
        } catch(Exception e){
            month = Integer.parseInt(data2[0]);
        }
        day = Integer.parseInt(data2[1]);
        year = Integer.parseInt(data2[2]);
    }

    public void setMonth(int m) {
        if (1 <= m && m <= 12) {
            month = m;
            day = Math.min(day, month_to_days[month]);
        }
    }

    public void setDay(int d) {
        if (1 <= d && d <= month_to_days[month]) {
            day = d;
        }
    }

    public void setYear(int y) {
        year = y;
    }

    public int between(MyDate other) {
        return between(other.toString());
    }    

    public int between(String data) {
        String[] data2 = data.split(" ");
        int m2 = months_to_int.get(data2[0].toUpperCase());
        int d2 = Integer.parseInt(data2[1]);
        int y2 = Integer.parseInt(data2[2]);

        int days = year*365 + mdToDays(month, day);
        int days2 = y2*365 + mdToDays(m2, d2);

        return days2 - days;
    }

    public String toString() {
        return int_to_months[month-1] + " " + day + " " + year;
    }

    private int mdToDays(int m, int d) {
        int ret = 0;
        for (int i = 0; i < m-1; ++i) {
            ret += month_to_days[i];
        }
        ret += d;
        return ret;
    }
}