package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private ArrayList<ListItem> sublistItems = new ArrayList<>();
    private char bulletStyle;
    private int subCount;

    public ListItem(String text) {
        // this() 생성자, 함수 오버로딩
        this(text, '*');
    }

    public ListItem(final String text, final char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return this.bulletStyle;
    }

    public void setBulletStyle(final char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public void addSublistItem(final ListItem sublistItem) {
        this.sublistItems.add(sublistItem);
    }

    public void removeSublistItem(final int index) {
        this.sublistItems.remove(index);
    }

    public void getSublistItem(final int index) {
        // ArrayList : add, remove, get
        this.sublistItems.get(index);
    }

    private void addSubCount(final int subCount) {
        this.subCount = subCount + 1;
    }

    public String toString() {
        // StringBuilder, sb.append, sb.toString, String.format
        final StringBuilder sb = new StringBuilder();
        final String INDENT = "    ";
        for (int i = 0; i < this.subCount; i++) {
            sb.append(INDENT);
        }
        sb.append(String.format("%c %s%s", this.bulletStyle, this.text, System.lineSeparator()));
        for (ListItem item : sublistItems) {
            item.addSubCount(this.subCount);
            sb.append(item.toString());
        }
        return sb.toString();
    }
}
