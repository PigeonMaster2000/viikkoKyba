package com.example.viikon10tehtavat;

import java.util.ArrayList;

public class Library {
    private static Library library = new Library();
    int currentUrlIndex;
    ArrayList<String>  urlList;

    private Library(){
        urlList = new ArrayList<String>();
        currentUrlIndex = -1;
    }
    public static Library getInstance(){
        return library;
    }


    public String getCurrentUrl(){
        //get current url
        return urlList.get(currentUrlIndex);
    }

    public void addNewUrl(String newUrl){
        // when something is searched
        if (urlList.size() > currentUrlIndex+1){
            // if currentUrlIndex does not point at latest url in the list, remove elements starting from the latest, until currentUrlIndex points at the latest url
            // in clear text, if user enters something after going back, rest wil clear and user is back in the "newest" site
            while (urlList.size() > currentUrlIndex+1) {
                urlList.remove(urlList.size()-1);
            }
        }
        if (urlList.size() >= 10){
            // if we are in the latest url, but the max of 10 urls have been reached, delete oldest url and add this one as latest
            urlList.remove(0);
            currentUrlIndex--;
        }
        System.out.println("AASDSAASDASD"+newUrl);
        if (newUrl.equals("http://index.html")){
            newUrl = "file:///android_asset/index.html";
            System.out.println("MOIMOI");
        }
        urlList.add(newUrl);
        currentUrlIndex++;
    }

    public String goBack(){
        //go back
        if (currentUrlIndex > 0) {
            currentUrlIndex--;
        }
        return urlList.get(currentUrlIndex);
    }

    public String goNext(){
        //go next
        if (currentUrlIndex+1 < urlList.size()){
            currentUrlIndex++;
        }
        return urlList.get(currentUrlIndex);
    }


}
