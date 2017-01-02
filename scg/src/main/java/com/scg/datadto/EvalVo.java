package com.scg.datadto;

/**
 * Created by sungbo on 2016-09-01.
 */
public class EvalVo {

    private float avg;
    private int sum;

    public EvalVo(){}

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "EvalVo{" +
                "avg=" + avg +
                ", sum=" + sum +
                '}';
    }
}
