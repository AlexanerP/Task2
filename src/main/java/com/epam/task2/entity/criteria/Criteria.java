package com.epam.task2.entity.criteria;

import java.io.Serializable;
import java.util.*;

public class Criteria implements Serializable {

    private String searchWord;
    private List<String> listSearchWord = new ArrayList<>();

    public Criteria() {
    }

    public Criteria(String searchWord) {
        this.searchWord = searchWord;
        add(searchWord);
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
        add(searchWord);
    }

    public List<String> getListSearchWord() {
        return listSearchWord;
    }

    public void setListSearchWord(List<String> listSearchWord) {
        this.listSearchWord = listSearchWord;
    }

    public void add(String searchWord) {
        listSearchWord.add(searchWord);
    }
    }

