package com.example.cabdproject.services;

import com.example.cabdproject.entities.Product;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedureService {
    public List<Product> getProductsProcedure() {
        List<Product> productList = new ArrayList<>();
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cabdProject", "root", "root");

            CallableStatement callableStatement = con.prepareCall("{call CurrentProducts()}");
            try (ResultSet rs = callableStatement.executeQuery()) {
                while (rs.next()) {
                    Integer id = rs.getInt("id_p");
                    String name = rs.getString("name_p");
                    Double price = rs.getDouble("price");
                    String category = rs.getString("category");

                    productList.add(new Product(id, name, price, category));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return productList;
    }
}
