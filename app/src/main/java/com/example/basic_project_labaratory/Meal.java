package com.example.basic_project_labaratory;

public class Meal { // 식사에 대한 정보를 저장하는 클래스
    private Food[] foods; // 음식 배열
    private int n_foods; // 음식 배열에 저장된 음식의 개수
    private int cal, carbs, protein, fat, sodium; // 영양정보

    public Meal(int cal, int carbs, int protein, int fat, int sodium){ // 생성자
        this.foods = new Food[20]; // 반찬 개수 20개까지
        this.n_foods = 0;
    }
    public int getCal(){return this.cal;}
    public int getCarbs(){return this.carbs;}
    public int getProtein(){return this.protein;}
    public int getFat(){return this.fat;}
    public int getSodium(){return this.sodium;}

    public void addFood(Food food){ // 음식 추가
        this.foods[this.n_foods] = food;
        this.n_foods++;
        this.cal = food.getCal();
        this.carbs = food.getCarbs();
        this.protein = food.getProtein();
        this.fat = food.getFat();
        this.sodium = food.getSodium();
    }

}
