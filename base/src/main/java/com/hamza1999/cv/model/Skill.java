package com.hamza1999.cv.model;

import java.util.ArrayList;

public class Skill {
    private String skill;
    private float rating;

    public Skill(String skill, float rating) {
        this.skill = skill;
        this.rating = rating;
    }

    public String getSkill() {
        return skill;
    }

    public float getRating() {
        return rating;
    }

    public static ArrayList<Skill> getAllSkills(){
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Android",3.5f));
        skills.add(new Skill("Java",3.5f));
        skills.add(new Skill("Web Development",4.0f));
        skills.add(new Skill("Asp.Net MVC",4.0f));
        skills.add(new Skill("C++",3.5f));
        return skills;
    }
}
