package inheritance.vehicle;

import inheritance.IColorAware;

public abstract class AbstractVehicle implements IColorAware {

    public void paint() {
        System.out.println("Красим транспорт");
    }
}
