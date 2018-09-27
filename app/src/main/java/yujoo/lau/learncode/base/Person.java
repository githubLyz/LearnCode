package yujoo.lau.learncode.base;

/**
 * @author LEW.LIU
 * @date 2018/8/10
 * @description
 */

public class Person {
    private String name;
    private int age;
    private double height;
    private double weight;
    private Person(Builder builder) {
        this.name=builder.name;
        this.age=builder.age;
        this.height=builder.height;
        this.weight=builder.weight;
    }


   public static class Builder{
        private String name;
        private int age;
        private double height;
        private double weight;
        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder age(int age){
            this.age=age;
            return this;
        }
        public Builder height(double height){
            this.height=height;
            return this;
        }

        public Builder weight(double weight){
            this.weight=weight;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
