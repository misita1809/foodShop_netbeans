/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodshop;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Product {
    private int productId;
    private String productName;
    private int weight;
    private double price;
    private double priceWithVat;
    private Date expiryDate;
    private String imagePath;
    private Date estimateOrderDate;

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the expiryDate
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return the estimateOrderDate
     */
    public Date getEstimateOrderDate() {
        return estimateOrderDate;
    }

    /**
     * @param estimateOrderDate the estimateOrderDate to set
     */
    public void setEstimateOrderDate(Date estimateOrderDate) {
        this.estimateOrderDate = estimateOrderDate;
    }

    /**
     * @return the priceWithVat
     */
    public double getPriceWithVat() {
        return priceWithVat;
    }

    /**
     * @param priceWithVat the priceWithVat to set
     */
    public void setPriceWithVat(double priceWithVat) {
        this.priceWithVat = priceWithVat;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return productId + " " + productName;
    }
    
}
