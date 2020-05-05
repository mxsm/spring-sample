package com.github.mxsm;

import org.openjdk.jol.info.ClassLayout;

public class HeaderView {

    public static void main(String[] args) {

        HeaderView[] headerView = new HeaderView[1];
        System.out.println(ClassLayout.parseInstance(headerView).toPrintable());

        HeaderView headerView1 = new HeaderView();
        System.out.println(ClassLayout.parseInstance(headerView1).toPrintable());

    }

}
