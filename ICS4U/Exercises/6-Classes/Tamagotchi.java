
public class Tamagotchi {

    int hunger, happiness, discipline;
    int age;
    String name;

    public Tamagotchi(String name) {
        this.name = name;
        hunger = happiness = discipline = 50;
        age = 0;
    }

    public void boundCheck() {
        happiness = Math.max(happiness, 0);
        happiness = Math.min(happiness, 100);
        hunger = Math.max(hunger, 0);
        hunger = Math.min(hunger, 100);
        discipline = Math.max(discipline, 0);
        discipline = Math.min(discipline, 100);
    }

    public void age() {
        age += 1;
        happiness--;
        discipline--;
        hunger++;
        boundCheck();
    }

    public void feed() {
        hunger -= 10;
        boundCheck();
    }

    public void play() {
        happiness += 10;
        boundCheck();
    }

    public void scold() {
        discipline += 10;
        boundCheck();
    }

    public String minToDays(int mins) {
        String ret = "";

        int counter = 0;
        while (mins >= 24*60) {
            mins -= 24*60;
            counter++;
        }

        ret += Integer.toString(counter) + " days ";
        counter = 0;

        while (mins >= 60) {
            mins -= 60;
            counter++;
        }

        ret += Integer.toString(counter) + " hours " + Integer.toString(mins) + " minutes";
        return ret;
    }

    public String barMaker(int num, int bar_length) {
        int r = (int)(((double)num / 100) * bar_length);
        String ret = "■".repeat(r);
        ret += "-".repeat(bar_length - r);
        return ret;
    }

    public String toString() {
        String out = "%s | Age: %s | Happiness: %s Hunger: %s Discipline: %s";

        return String.format(out, name, minToDays(age), barMaker(happiness, 5), barMaker(hunger, 5), barMaker(discipline, 5));
    }
}