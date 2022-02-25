/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodshop;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author hp
 */
public class DataHolder {
    private List<Product> products;
    private List<Stock> stocks;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private int productId = 0;
  
    private static DataHolder mInstance;
    
    private DataHolder() {
        products = new ArrayList<>();
        stocks = new ArrayList<>();
        load();
        loadProductId();
        loadStock();
        
    }
    
    public static DataHolder getDefault(){
        if(mInstance == null){
            mInstance = new DataHolder();
        }
        return mInstance;
    }
    
    public void removeProduct(Product product){
        products =  products.stream().filter((e) -> e.getProductId() != product.getProductId()).collect(Collectors.toList());
        save();
    }
    
    public void removeStock(Stock stock){
        stocks =  stocks.stream().filter((e) -> e.getProductId() == stock.getProductId())
                .collect(Collectors.toList());
        saveStock();
    }
    
    
    public String dateToString(Date date){
        return sdf.format(date);
    }
    
    public void addProduct(Product product){
        if(product.getProductId() == 0){
            product.setProductId(getNextProductId());    
        }
        products.add(product);
        save();
    }
    
    public List<Product> getProduct(){
        return products;
    }
    
    public List<Stock> getStocks(){
        return stocks;
    }
    
    public void save(){
        try{
            FileWriter writer = new FileWriter(new File("products.txt"));
            for(int i =0; i < products.size(); i++){
                Product e = products.get(i);
                writer.write(String.valueOf(e.getProductId()));
                writer.write("##");
                writer.write(e.getProductName());
                writer.write("##");
                writer.write(String.valueOf(e.getPrice()));
                writer.write("##");
                writer.write(String.valueOf(e.getPriceWithVat()));
                writer.write("##");
                writer.write(String.valueOf(e.getWeight()));
                writer.write("##");
                writer.write(sdf.format(e.getExpiryDate()));
                writer.write("##");
                writer.write(sdf.format(e.getEstimateOrderDate()));
                writer.write("##");
                writer.write(e.getImagePath());

            }
            writer.flush();
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
      public void saveStock(){
        try{
            FileWriter writer = new FileWriter(new File("stock.txt"));
            for(int i =0; i < stocks.size(); i++){
                Stock e = stocks.get(i);
                writer.write(String.valueOf(e.getProductId()));
                writer.write("##");
                writer.write(e.getProductName());
                writer.write("##");
                writer.write(String.valueOf(e.getPrice()));
                writer.write("##");
                writer.write(String.valueOf(e.getPriceWithVat()));
                writer.write("##");
                writer.write(String.valueOf(e.getWeight()));
                writer.write("##");
                writer.write(sdf.format(e.getExpiryDate()));
                writer.write("##");
                writer.write(sdf.format(e.getEstimateOrderDate()));
                writer.write("##");
                writer.write(e.getImagePath());
                writer.write("##");
                writer.write(e.getQty());
            }
            writer.flush();
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void loadStock(){
        try{
            File file = new File("stock.txt");
            if(!file.exists()){
                return;
            }
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String value = scanner.nextLine();
                String[] values =  value.split("##");
                Stock product = new Stock();
                product.setProductId(Integer.valueOf(values[0]));
                product.setProductName(values[1]);
                product.setPrice(Double.valueOf(values[2]));
                product.setPriceWithVat(Double.valueOf(values[3]));
                product.setWeight(Integer.valueOf(values[4]));
                product.setExpiryDate(sdf.parse(values[5]));
                product.setEstimateOrderDate(sdf.parse(values[6]));
                product.setImagePath(values[7]);
                product.setQty(Integer.valueOf(values[8]));
                stocks.add(product);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void load(){
        try{
            File file = new File("products.txt");
            if(!file.exists()){
                return;
            }
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String value = scanner.nextLine();
                String[] values =  value.split("##");
                Product product = new Product();
                product.setProductId(Integer.valueOf(values[0]));
                product.setProductName(values[1]);
                product.setPrice(Double.valueOf(values[2]));
                product.setPriceWithVat(Double.valueOf(values[3]));
                product.setWeight(Integer.valueOf(values[4]));
                product.setExpiryDate(sdf.parse(values[5]));
                product.setEstimateOrderDate(sdf.parse(values[6]));
                product.setImagePath(values[7]);
                products.add(product);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public int getNextProductId(){
        ++productId;
        try{
            FileWriter writer = new FileWriter(new File("productId.txt"));
            writer.write(String.valueOf(productId));
            writer.flush();
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return productId;
    }
    
    private void loadProductId(){
        try{
            
            Scanner scanner = new Scanner(new File("productId.txt"));
            if(scanner.hasNext()){
                String nextVal = scanner.nextLine();
                productId = Integer.valueOf(nextVal);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
