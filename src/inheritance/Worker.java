package inheritance;

import inheritance.shape.Circle;
import inheritance.shape.Square;
import inheritance.vehicle.Car;

public class Worker {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.executeWork(new Circle());
        worker.executeWork(new Square());
        worker.executeWork(new Car());
    }

    public void executeWork(IColorAware v) {
        v.paint();
        if (v instanceof IDateAware) {
            IDateAware objectWithDate = (IDateAware) v;
            System.out.println("Объект с датой:" + objectWithDate.getCreationDate());
        }
    }
}
