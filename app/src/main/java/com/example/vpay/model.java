package com.example.vpay;

public class model
{
  String card_no, expiry_month, expiry_year, cvv_no, amount, customer_name, mobile_no;

    public model(String card_no, String expiry_month, String expiry_year, String cvv_no, String amount, String customer_name, String mobile_no) {
        this.card_no = card_no;
        this.expiry_month = expiry_month;
        this.expiry_year = expiry_year;
        this.cvv_no = cvv_no;
        this.amount = amount;
        this.customer_name = customer_name;
        this.mobile_no = mobile_no;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getExpiry_month() {
        return expiry_month;
    }

    public void setExpiry_month(String expiry_month) {
        this.expiry_month = expiry_month;
    }

    public String getExpiry_year() {
        return expiry_year;
    }

    public void setExpiry_year(String expiry_year) {
        this.expiry_year = expiry_year;
    }

    public String getCvv_no() {
        return cvv_no;
    }

    public void setCvv_no(String cvv_no) {
        this.cvv_no = cvv_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}
