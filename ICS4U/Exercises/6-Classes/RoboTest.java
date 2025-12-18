public class RoboTest{

    public static void main(String[] arguments) {
		MyRobot robo = new MyRobot(50, 20, 90);

		robo.advance(50);
		System.out.println(robo);
		robo.turn(-600);
		robo.advance(50);
		System.out.println(robo);
		
		/* expected output:
		 * X: 50.0 Y: 70.0 Heading: 90.0 
		 * X:  6.7 Y: 45.0 Heading: 210.0 
		 */
    }
}