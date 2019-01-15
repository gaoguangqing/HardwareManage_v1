package com.hd.pojo;

import java.io.Serializable;

public class Mainframe implements Serializable {
    private Integer id;

    private String brand;

    private String name;

    private Long price;

    private Integer amount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

	@Override
	public String toString() {
		return "Mainframe [id=" + id + ", brand=" + brand + ", name=" + name + ", price=" + price + ", amount=" + amount
				+ "]";
	}
    
}