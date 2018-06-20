package ultigreen.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;


@Entity
@Table(name= "dining_footprint")
public class FoodEntry {

    public FoodEntry() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private BigDecimal lamb;

    private BigDecimal beef;

    private BigDecimal cheese;

    private BigDecimal pork;

    private BigDecimal turkey;

    private BigDecimal chicken;

    private BigDecimal tuna;

    private BigDecimal eggs;

    private BigDecimal potatoes;

    private BigDecimal rice;

    private BigDecimal nuts;
    
    private BigDecimal beans;

    private BigDecimal tofu;

    private BigDecimal vegetables;

    private BigDecimal milk;

    private BigDecimal fruit;
}