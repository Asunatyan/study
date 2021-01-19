package com.dqk.test.typeHandler;

import org.apache.ibatis.type.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class MyTypeHandler implements TypeHandler<String> {

/*

    public MyTypeHandler() {
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {

        ps.setString(i, parameter);

    }

    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnName);
        if (sqlTimestamp != null) {
            SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dataFormat.format(new Date(sqlTimestamp.getTime()));
        } else {
            return null;
        }
    }

    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnIndex);
        if (sqlTimestamp != null) {
            SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dataFormat.format(new Date(sqlTimestamp.getTime()));
        } else {
            return null;
        }
    }

    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = cs.getTimestamp(columnIndex);
        if (sqlTimestamp != null) {
            SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dataFormat.format(new Date(sqlTimestamp.getTime()));
        } else {
            return null;
        }
    }
*/


    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public MyTypeHandler() {
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

        try {
            Date parse = dataFormat.parse(s);
            preparedStatement.setTimestamp(i, new Timestamp(parse.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        Timestamp sqlTimestamp = resultSet.getTimestamp(s);
        if (sqlTimestamp != null) {
            return dataFormat.format(new Date(sqlTimestamp.getTime()));
        } else {
            return null;
        }
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        Timestamp sqlTimestamp = resultSet.getTimestamp(i);
        if (sqlTimestamp != null) {
            return dataFormat.format(new Date(sqlTimestamp.getTime()));
        } else {
            return null;
        }
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = cs.getTimestamp(columnIndex);
        if (sqlTimestamp != null) {
            return dataFormat.format(new Date(sqlTimestamp.getTime()));
        } else {
            return null;
        }
    }

}
