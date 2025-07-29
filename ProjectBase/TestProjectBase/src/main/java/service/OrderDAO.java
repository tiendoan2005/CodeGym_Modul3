package service;


import model.Item;
import model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderDAO {

    public void checkOut(List<Item> cart) throws SQLException {
        String queryOrder = "{CALL sp_insert_orders(?,?,?)}";
        String queryOrderDetail = "{CALL sp_insert_order_detail(?,?,?)}";

        int orderId = -1;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            connection.setAutoCommit(false);
            //Add new Order
            //Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String orderDate = format.format(new Date());
            //order.setOrderDate(orderDate);
            double totalPrice = 0;
            for (Item item : cart) {
                Product product = item.getProduct();
                totalPrice += product.getPrice() * item.getQuantity();
            }
            //order.setTotalPrice(totalPrice);
            Date _orderDate = format.parse(orderDate);
            CallableStatement callableStatementOrder = connection.prepareCall(queryOrder);
            callableStatementOrder.setDate(1, new java.sql.Date(_orderDate.getTime()));
            callableStatementOrder.setDouble(2, totalPrice);
            callableStatementOrder.registerOutParameter(3, Types.INTEGER);
            callableStatementOrder.executeUpdate();
            orderId = callableStatementOrder.getInt(3);

            //Add new OrderDetail
            for (Item item : cart) {
                Product product = item.getProduct();
                //OrderDetail orderDetail = new OrderDetail();
                //orderDetail.setOrderId(orderId);
                //orderDetail.setProductId(product.getId());
                //orderDetail.setQuantity(item.getQuantity());
                CallableStatement callableStatementOrderDetail = connection.prepareCall(queryOrderDetail);
                callableStatementOrderDetail.setInt(1, orderId);
                callableStatementOrderDetail.setInt(2, product.getId());
                callableStatementOrderDetail.setInt(3, item.getQuantity());
                callableStatementOrderDetail.executeUpdate();
            }
            connection.commit();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            DBConnection.printSQLException(e);
        }
    }

    public int getCounter(int counter, int inc) throws SQLException {
        String query = "{CALL sp_get_counters(?,?)}";
        int outCounter = -1;
        try (Connection connection = DBConnection.getConnection();
             CallableStatement statement = connection.prepareCall(query);) {
            statement.setInt(1, counter);
            statement.setInt(2, inc);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.executeQuery();
            outCounter = statement.getInt(1);
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return outCounter;
    }
}


