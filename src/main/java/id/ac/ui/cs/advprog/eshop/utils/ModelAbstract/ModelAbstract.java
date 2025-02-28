package id.ac.ui.cs.advprog.eshop.utils.ModelAbstract;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class ModelAbstract {
    private String id;

    protected ModelAbstract() {
        this.id = UUID.randomUUID().toString();
    }

}
