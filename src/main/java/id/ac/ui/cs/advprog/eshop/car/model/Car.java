package id.ac.ui.cs.advprog.eshop.car.model;

import id.ac.ui.cs.advprog.eshop.utils.ModelAbstract.ModelAbstract;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Car extends ModelAbstract {
    private String carName;
    private String carColor;
    private int carQuantity;
}
