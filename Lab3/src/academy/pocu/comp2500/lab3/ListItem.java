package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private final ArrayList<ListItem> sublistItems = new ArrayList<>();
    private char bulletStyle;
    private int subCount;

    public ListItem(String text) {
        // this() 생성자, 함수 오버로딩
        this(text, '*');
    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return this.bulletStyle;
    }

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public void addSublistItem(ListItem sublistItem) {
        this.sublistItems.add(sublistItem);
    }

    public void removeSublistItem(int index) {
        this.sublistItems.remove(index);
    }

    public void getSublistItem(int index) {
        // ArrayList : add, remove, get
        this.sublistItems.get(index);
    }

    public void plusSubCount(int subCount) {
        this.subCount += subCount + 1;
    }

    public String toString() {
        // StringBuilder, sb.append, sb.toString, String.format
        String indents = "";
        for (int i = 0; i < this.subCount ; i++) {
            indents += "    ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%c %s%s", indents, this.bulletStyle, this.text, System.lineSeparator()));
        for (ListItem item : sublistItems) {
            item.plusSubCount(this.subCount);
            sb.append(item.toString());
        }
        return sb.toString();
    }
}
