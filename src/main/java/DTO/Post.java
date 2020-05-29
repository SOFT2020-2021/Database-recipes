package DTO;

import java.util.Date;

public class Post {

    //fields
    // _id , text , username , date
    // recipe

    private String id;
    private String body;
    private String username;
    private Date date;
    private String[] ingridents;
    private int[] ingridentsAmount;
    private String[] nutrients;
    private int[] nutrientsAmount;







    public void Post(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getIngridents() {
        return ingridents;
    }

    public void setIngridents(String[] ingridents) {
        this.ingridents = ingridents;
    }

    public int[] getIngridentsAmount() {
        return ingridentsAmount;
    }

    public void setIngridentsAmount(int[] ingridentsAmount) {
        this.ingridentsAmount = ingridentsAmount;
    }

    public String[] getNutrients() {
        return nutrients;
    }

    public void setNutrients(String[] nutrients) {
        this.nutrients = nutrients;
    }

    public int[] getNutrientsAmount() {
        return nutrientsAmount;
    }

    public void setNutrientsAmount(int[] nutrientsAmount) {
        this.nutrientsAmount = nutrientsAmount;
    }
}
