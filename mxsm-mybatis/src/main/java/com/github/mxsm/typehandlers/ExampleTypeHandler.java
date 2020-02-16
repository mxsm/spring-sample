package com.github.mxsm.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/9 20:43
 */
@MappedTypes(value = {String.class})
@MappedJdbcTypes(value = JdbcType.VARCHAR)
public class ExampleTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
        throws SQLException {
        return rs.getString(columnName) + " handler";
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
        throws SQLException {
        return rs.getString(columnIndex) + " handler";
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
        throws SQLException {
        return cs.getString(columnIndex) + " handler";
    }
}
