
import java.util.Arrays;

class Elevator {
    
    private int floor_count;
    private int cur_floor = 0;
    public int[] requests;

    public Elevator(int floor_count) {
        this.floor_count = floor_count+1;
        this.requests = new int[floor_count+1];
    }

    public void request(int floor) {
        ++requests[floor];
    }

    public void display() {
        System.out.println(Arrays.toString(requests));
        System.out.println(" " + "   ".repeat(cur_floor) + "E");
    }

    private int dir = 1;
    public void move() {
        if (requests[cur_floor] > 0) {
            requests[cur_floor] = 0;
            return;
        }
        
        for (int i = cur_floor + dir; i >= 0 && i < floor_count; i += dir) {
            if (requests[i] > 0) {
                cur_floor += dir;
                return;
            }
        }

        dir = -dir;
        for (int i = cur_floor + dir; i >= 0 && i < floor_count; i += dir) {
            if (requests[i] > 0) {
                cur_floor += dir;
                return;
            }
        }
    }
}