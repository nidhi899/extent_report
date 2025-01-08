package com.mappls.map.dataGenerator;

import java.util.Objects;


public class Items {
	private String title;
    private String desc;
    private String type;
    private String date;

    public Items(String title, String desc, String type, String date) {
        this.title = title;
        this.desc = desc;
        this.type = type;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items item = (Items) o;
        return Objects.equals(title, item.title) &&
                Objects.equals(desc, item.desc) &&
                Objects.equals(type, item.type) &&
                Objects.equals(date, item.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, desc, type, date);
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
