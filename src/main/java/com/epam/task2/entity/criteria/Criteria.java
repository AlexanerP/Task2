package com.epam.task2.entity.criteria;

import java.io.Serializable;
import java.util.*;

/**
 * @author Alexander Pishchala
 *
 * This is the class of the entity 'Criteria'.
 * Here are the main search criteria by which products will be searched.
 */
public class Criteria implements Serializable {

    private static final long serialVersionUID = -7696742141914073282L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criteria that = (Criteria) o;
        return Objects.equals(searchWord, that.searchWord) &&
                Objects.equals(listSearchWord, that.listSearchWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchWord, listSearchWord);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Criteria{").append("listSearchWord=").append(listSearchWord);
        return stringBuilder.toString();
    }
}

