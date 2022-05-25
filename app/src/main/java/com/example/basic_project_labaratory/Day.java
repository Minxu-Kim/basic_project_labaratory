package com.example.basic_project_labaratory;

public class Day { // 일일 식사와 영양정보를 저장하는 클래스
    private int year, month, day; // 날짜
    private Meal[] meals; // 식사 배열
    private int n_meals; // 식사 배열에 저장된 식사의 수
    private int cal, carbs, protein, fat, sodium; // 일일 영양소 합계

    public Day(int year, int month, int day){ // 생성자
        this.year = year; this.month = month; this.day = day;
        this.meals = new Meal[3]; // 식사는 하루 3회로 제한
        this.n_meals = 0;
    }
    public int getYear(){return this.year;}
    public int getMonth(){return this.month;}
    public int getDay(){return this.day;}
    public int getCal(){return this.cal;}
    public int getCarbs(){return this.carbs;}
    public int getProtein(){return this.protein;}
    public int getFat(){return this.fat;}
    public int getSodium(){return this.sodium;}

    public void addMeal(Meal meal){ // 식사 추가
        this.meals[this.n_meals] = meal;
        this.n_meals++;
        this.cal += meal.getCal();
        this.carbs += meal.getCarbs();
        this.protein += meal.getProtein();
        this.fat += meal.getFat();
        this.sodium += meal.getSodium();
    }

}
