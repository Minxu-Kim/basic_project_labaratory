package com.example.basic_project_labaratory;

import android.widget.EditText;

public class memberinput {

    private String weight;
    private  String height;
    private String age;
    private String name;

    memberinput(String weight, String height, String age, String name){
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.name = name;
    }

    public String getWeight(){
        return this.weight;
    }
    public void setWeight(String newWeight){
        this.weight = newWeight;
    }
    public String getHeight(){
        return this.height;
    }
    public void setHeight(String newHeight){
        this.height = newHeight;
    }
    public String getAge(){
        return this.age;
    }
    public void setAge(String newAge){
        this.age = newAge;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }
}
