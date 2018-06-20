package ultigreen.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="dining_footprint")
public class FoodEntry {

    public FoodEntry() {}

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
	
	private Date date;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

    /**
	 * @return the fruit
	 */
	public BigDecimal getFruit() {
		return fruit;
	}

	/**
	 * @param fruit the fruit to set
	 */
	public void setFruit(BigDecimal fruit) {
		this.fruit = fruit;
	}

	/**
	 * @return the milk
	 */
	public BigDecimal getMilk() {
		return milk;
	}

	/**
	 * @param milk the milk to set
	 */
	public void setMilk(BigDecimal milk) {
		this.milk = milk;
	}

	/**
	 * @return the tofu
	 */
	public BigDecimal getTofu() {
		return tofu;
	}

	/**
	 * @param tofu the tofu to set
	 */
	public void setTofu(BigDecimal tofu) {
		this.tofu = tofu;
	}

	/**
	 * @return the beans
	 */
	public BigDecimal getBeans() {
		return beans;
	}

	/**
	 * @param beans the beans to set
	 */
	public void setBeans(BigDecimal beans) {
		this.beans = beans;
	}

	/**
	 * @return the nuts
	 */
	public BigDecimal getNuts() {
		return nuts;
	}

	/**
	 * @param nuts the nuts to set
	 */
	public void setNuts(BigDecimal nuts) {
		this.nuts = nuts;
	}

	/**
	 * @return the rice
	 */
	public BigDecimal getRice() {
		return rice;
	}

	/**
	 * @param rice the rice to set
	 */
	public void setRice(BigDecimal rice) {
		this.rice = rice;
	}

	/**
	 * @return the eggs
	 */
	public BigDecimal getEggs() {
		return eggs;
	}

	/**
	 * @param eggs the eggs to set
	 */
	public void setEggs(BigDecimal eggs) {
		this.eggs = eggs;
	}

	/**
	 * @return the tuna
	 */
	public BigDecimal getTuna() {
		return tuna;
	}

	/**
	 * @param tuna the tuna to set
	 */
	public void setTuna(BigDecimal tuna) {
		this.tuna = tuna;
	}

	/**
	 * @return the chicken
	 */
	public BigDecimal getChicken() {
		return chicken;
	}

	/**
	 * @param chicken the chicken to set
	 */
	public void setChicken(BigDecimal chicken) {
		this.chicken = chicken;
	}

	/**
	 * @return the turkey
	 */
	public BigDecimal getTurkey() {
		return turkey;
	}

	/**
	 * @param turkey the turkey to set
	 */
	public void setTurkey(BigDecimal turkey) {
		this.turkey = turkey;
	}

	/**
	 * @return the pork
	 */
	public BigDecimal getPork() {
		return pork;
	}

	/**
	 * @param pork the pork to set
	 */
	public void setPork(BigDecimal pork) {
		this.pork = pork;
	}

	/**
	 * @return the cheese
	 */
	public BigDecimal getCheese() {
		return cheese;
	}

	/**
	 * @param cheese the cheese to set
	 */
	public void setCheese(BigDecimal cheese) {
		this.cheese = cheese;
	}

	/**
	 * @return the beef
	 */
	public BigDecimal getBeef() {
		return beef;
	}

	/**
	 * @param beef the beef to set
	 */
	public void setBeef(BigDecimal beef) {
		this.beef = beef;
	}

	/**
	 * @return the lamb
	 */
	public BigDecimal getLamb() {
		return lamb;
	}

	/**
	 * @param lamb the lamb to set
	 */
	public void setLamb(BigDecimal lamb) {
		this.lamb = lamb;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the vegetables
	 */
	public BigDecimal getVegetables() {
		return vegetables;
	}

	/**
	 * @param vegetables the vegetables to set
	 */
	public void setVegetables(BigDecimal vegetables) {
		this.vegetables = vegetables;
    }

    /**
	 * @return the potatoes
	 */
	public BigDecimal getPotatoes() {
		return potatoes;
	}

	/**
	 * @param vegetables the potatoes to set
	 */
	public void setPotatoes(BigDecimal potatoes) {
		this.potatoes = potatoes;
    }
}