package org.mybatis.example;

public class Blog {

    int bId;
    String bName;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                '}';
    }
}
