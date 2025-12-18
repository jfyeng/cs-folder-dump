
class Rect {
    // FIELDS
    private double x, y;
    private double width, height;

    // CONSTRUCTOR
    public Rect(double x, double y, double width, double height) {
        this.x = x; this.y = y; this.width = width; this.height = height;
    }

    // METHODS
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public double getWidth() { return this.width; }
    public double getHeight() { return this.height; }

    public double[] centre() {
        double[] c = new double[2];
        c[0] = this.x + (this.width/2);
        c[1] = this.y + (this.height/2);
        return c;
    }

    public boolean overlaps(Rect rectangle) {
        if (rectangle.x > this.x + this.width) return false;
        if (rectangle.x + rectangle.width < this.x) return false;
        if (rectangle.y > this.y + this.height) return false;
        if (rectangle.y + rectangle.height < this.y) return false;
        return true;
    }

    public boolean contains(int x, int y) {
        if (this.x <= x && x <= this.x + this.width &&
            this.y <= y && y <= this.y + this.height) return true;
        return false;
    }

    public void translate(int dx, int dy) { this.x += dx; this.y += dy; }
    public Rect union(Rect rectangle) {
        double ux = Math.min(this.x, rectangle.x), uy = Math.min(this.y, rectangle.y);
        double uw = Math.max(this.x + this.width, rectangle.x + rectangle.width) - ux;
        double uh = Math.max(this.y + this.height, rectangle.y + rectangle.height) - uy;
        Rect union_rect = new Rect(ux, uy, uw, uh);
        return union_rect;
    }

    public void resize(double size) {
        double oldw = this.width, oldh = this.height;
        this.width *= size;
        this.height *= size;
        this.x += (oldw - this.width)/2;
        this.y += (oldh - this.height)/2;
    }

    public String toString() {
        return String.format("x: %f y: %f width: %f height: %f", this.x, this.y, this.width, this.height);
    }

}