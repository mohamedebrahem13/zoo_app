package com.example.myapplication.data;




import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repo {
   private  List<Animal>   animallist = new ArrayList<>();
   private  String[] alpha=new String[26];






    public List<Animal> setanimals() {
        animallist = new ArrayList<>();
        animallist.add(new Animal(R.raw.lion, R.drawable.l,appcontext.getAppContext().getResources().getString(R.string.lion),R.raw.l));
        animallist.add(new Animal(R.raw.monkeysound, R.drawable.m,appcontext.getAppContext().getResources().getString(R.string.monkey),R.raw.m));
        animallist.add(new Animal(R.raw.elephant, R.drawable.e,appcontext.getAppContext().getResources().getString(R.string.elephant) ,R.raw.e));
        animallist.add(new Animal(R.raw.goatsound,R.drawable.g,appcontext.getAppContext().getResources().getString(R.string.goat),R.raw.g));
        animallist.add(new Animal(R.raw.dogsound,R.drawable.d,appcontext.getAppContext().getResources().getString(R.string.dog),R.raw.d));
        animallist.add(new Animal(R.raw.snakesound,R.drawable.s,appcontext.getAppContext().getResources().getString(R.string.snake),R.raw.s));
        animallist.add(new Animal(R.raw.tuertle,R.drawable.t,appcontext.getAppContext().getResources().getString(R.string.turtle),R.raw.t));
        animallist.add(new Animal(R.raw.frogsound,R.drawable.f,appcontext.getAppContext().getResources().getString(R.string.frog),R.raw.f));
        animallist.add(new Animal(R.raw.crocodilesound,R.drawable.a,appcontext.getAppContext().getResources().getString(R.string.croco),R.raw.a));
        animallist.add(new Animal(R.raw.whalesound,R.drawable.w,appcontext.getAppContext().getResources().getString(R.string.whale),R.raw.w));
        animallist.add(new Animal(R.raw.camelsound,R.drawable.c,appcontext.getAppContext().getResources().getString(R.string.camal),R.raw.c));
        Collections.shuffle(animallist);
        Collections.shuffle(animallist);
        Collections.shuffle(animallist);
        return animallist;
    }


    public String[] setAlpha(){
        for (int i=0,j=65;i<26;i++,j++){
            alpha[i]=Character.toString((char) j);
        }
        return alpha;

    }





}
