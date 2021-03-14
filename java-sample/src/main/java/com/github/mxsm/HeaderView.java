package com.github.mxsm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author mxsm
 * @Date 2021/1/21
 * @Since
 */
public class HeaderView {

    public static void main(String[] args) {
        Header headerView = new Header();
        System.out.println("加锁之前.....");
        System.out.println(ClassLayout.parseInstance(headerView).toPrintable());
        headerView.hashCode();
        headerView.biasedLock();
        System.out.println("加锁之后.....");
        System.out.println(ClassLayout.parseInstance(headerView).toPrintable());
    }
}
