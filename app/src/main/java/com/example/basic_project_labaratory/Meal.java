package com.example.basic_project_labaratory;

public class Meal { // 식사에 대한 정보를 저장하는 클래스
    private int cal, carbs, protein, fat, sodium; // 영양정보

    public Meal(int cal, int carbs, int protein, int fat, int sodium){ // 생성자
        this.cal = cal;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
    }
    public int getCal(){return this.cal;}
    public int getCarbs(){return this.carbs;}
    public int getProtein(){return this.protein;}
    public int getFat(){return this.fat;}
    public int getSodium(){return this.sodium;}

}
