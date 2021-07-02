package com.liuwei.safety;

/**
 * @author wee
 * @Description:
 * @date 2020/10/12 10:46
 */
public class SheepTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        /*Sheep dl = new Sheep();
        Sheep dl2 = (Sheep)dl.clone();
        dl.setName("多莉a");
        Sheep dl3 = (Sheep)dl.clone();
        Sheep dl4 = (Sheep)dl.clone();
        System.out.println("dl===" + dl);
        System.out.println("d2===" + dl2);
        System.out.println("d3===" + dl3);
        System.out.println("d4===" + dl4);*/
        Sheep sheep = new Sheep();
        sheep.deepSheep = new DeepSheep();
        Sheep sheep1 = (Sheep) sheep.deepClone();

        System.out.println(sheep.deepSheep);
        System.out.println(sheep1.deepSheep);
    }
}
