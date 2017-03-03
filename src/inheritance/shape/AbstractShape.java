package inheritance.shape;

import inheritance.IColorAware;
import inheritance.IDateAware;

import java.util.Date;

public abstract class AbstractShape implements IColorAware, IDateAware {

    private Date creationDate;

    public AbstractShape() {
        super();
        creationDate = new Date();
    }

    @Override
    public void paint() {
        System.out.println("Красим фигуру");
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

}
