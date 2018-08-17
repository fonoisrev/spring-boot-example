package com.github.fonoisrev.bean;

public class Banana {
    
    private Apple apple;
    
    public Banana(Apple apple) {
        this.apple = apple;
    }
    
    public Apple getApple() {
        return this.apple;
    }
}
