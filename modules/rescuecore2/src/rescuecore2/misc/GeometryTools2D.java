package rescuecore2.misc;

/**
   A bunch of useful 2D geometry tools: finding line intersections, closest points and so on.
 */
public class GeometryTools2D {
    /**
       Find the intersection point of two lines.
     */
    public static Point getIntersectionPoint(Line l1, Line l2) {
        return null;
    }

    public static class Point {
        double x;
        double y;

        public Point(double x, Double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Point translate(double dx, double dy) {
            return new Point(x + dx, y + dy);
        }

        public Vector minus(Point p) {
            return new Vector(this.x - p.x, this.y - p.y);
        }
    }

    public static class Vector {
        private double dx;
        private double dy;
        private double length;

        public Vector(double dx, double dy) {
            this.dx = dx;
            this.dy = dy;
            length = Double.NaN;
        }

        public double getLength() {
            if (Double.isNaN(length)) {
                length = Math.hypot(dx, dy);
            }
            return length;
        }

        public double dot(Vector v) {
            return dx * v.dx + dy * v.dy;
        }

        public double getX() {
            return dx;
        }

        public double getY() {
            return dy;
        }

        public Vector add(Vector v) {
            return new Vector(dx + v.dx, dy + v.dy);
        }

        public Vector scale(double amount) {
            return new Vector(dx * amount, dy * amount);
        }

        public Vector normalised() {
            return scale(1.0 / getLength());
        }
    }

    public static class Line {
        private Point origin;
        private Vector direction;

        public Line(Point origin, Vector direction) {
            this.origin = origin;
            this.direction = direction;
        }

        public Point getPoint(double t) {
            return origin.translate(t * direction.getX(), t * direction.getY());
        }

        public Point getOrigin() {
            return origin;
        }

        public Vector getDirection() {
            return direction;
        }
    }
}