package com.github.mxsm.cglib.verification;

import net.sf.cglib.core.DefaultNamingPolicy;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Predicate;

/**
 * @author mxsm
 * @Date 2019/8/3 14:17
 * description:
 */
public class MxsmNamingPolicy extends DefaultNamingPolicy {

    public static final MxsmNamingPolicy INSTANCE = new MxsmNamingPolicy();

    public static final String TAG = "ByMxsmCglib";

    @Override
    protected String getTag() {
        return TAG;
    }
}
