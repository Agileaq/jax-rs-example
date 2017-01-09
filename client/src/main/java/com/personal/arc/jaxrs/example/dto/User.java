package com.personal.arc.jaxrs.example.dto;

/**
 * Created by Arc on 8/1/2017.
 */
public class User {

    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private Double money;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCellphone() {
        return cellphone;
    }

    public User setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public Double getMoney() {
        return money;
    }

    public User setMoney(Double money) {
        this.money = money;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", cellphone='").append(cellphone).append('\'');
        sb.append(", money=").append(money);
        sb.append('}');
        return sb.toString();
    }
}
