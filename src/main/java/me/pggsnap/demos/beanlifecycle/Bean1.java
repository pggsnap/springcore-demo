package me.pggsnap.demos.beanlifecycle;

/**
 * @author pggsnap
 * @date 2020/4/24
 */
public class Bean1 {
    public Bean1() {
        System.out.println("bean1 constructor...");
    }

    public void init() {
        System.out.println("bean1 init...");
    }

    public void destroy() {
        System.out.println("bean1 destroy...");
    }
}
