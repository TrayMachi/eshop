package id.ac.ui.cs.advprog.eshop.product.model;

import id.ac.ui.cs.advprog.eshop.utils.ModelAbstract.ModelAbstract;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product extends ModelAbstract {
    private String productName;
    private int productQuantity;
}
