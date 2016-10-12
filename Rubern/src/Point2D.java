/**
 * Created by Matias on 12/10/2016.
 */
public class Point2D {

    private double xPosition;
    private double yPosition;

    public Point2D(double x, double y){
        xPosition = x;
        yPosition = y;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public double getDistance(Point2D point){
        return Math.sqrt(Math.pow(point.getxPosition() - this.getxPosition(),2) + Math.pow(point.getyPosition() - this.getyPosition(),2));
    }

    public Point2D add(Point2D point){
        return new Point2D(this.getxPosition() + point.getxPosition(), this.getyPosition() + point.getyPosition());
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!this.getClass().equals(o.getClass())){
            return false;
        }
        Point2D point = (Point2D) o;
        if (this.getxPosition() == point.getxPosition() && this.getyPosition() == point.getyPosition()){
            return true;
        }
        return false;
    }
}
