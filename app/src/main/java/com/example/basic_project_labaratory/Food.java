package com.example.basic_project_labaratory;

public class Food { // 낱개의 음식에 대한 정보를 저장하는 클래스
    private String name; // 음식의 이름
    private int cal, carbs, protein, fat, sodium; // 영양정보

    public Food(String name, int cal, int carbs, int protein, int fat, int sodium){ // 생성자
        this.name = name;
        this.cal = cal;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
    }
    public String getName(){return this.name;}
    public int getCal(){return this.cal;}
    public int getCarbs(){return this.carbs;}
    public int getProtein(){return this.protein;}
    public int getFat(){return this.fat;}
    public int getSodium(){return this.sodium;}
}
