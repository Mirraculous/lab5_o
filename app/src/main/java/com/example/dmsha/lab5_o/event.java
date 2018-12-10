package com.example.dmsha.lab5_o;

import java.io.Serializable;

public class event implements Serializable {
    int id;
    String Name;
    String Comment;
    boolean Solved;
    int y,m,d;
    public event(String N, String C, boolean S, int y, int m, int d)
    {
        Name = N;
        Comment = C;
        Solved = S;
        this.id = id;
        this.y=y;
        this.m=m;
        this.d=d;
    }
    public event(String N, String C, boolean S)
    {
        Name = N;
        Comment = C;
        Solved = S;
        this.id = id;
        y = 0;
    }
}
