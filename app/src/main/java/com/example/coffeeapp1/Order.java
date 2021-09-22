package com.example.coffeeapp1;

public class Order {

    //attributes to be declared
    private int _id;
    private String _custName;
    private int _salesAmount;


    //Default constructor
    public Order() {
        _id = 0;
        _custName = null;
        _salesAmount = 0;
    }


// 2nd construtor

    public Order(String custName, int salesAmount) {
        this._custName = custName;
        this._salesAmount = salesAmount;
    }


    // get and set methods

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCustName() {
        return _custName;
    }

    public void setCustName(String custName) {
        this._custName = custName;
    }

    public double getSalesAmount() {
        return _salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this._salesAmount = salesAmount;
    }
}
