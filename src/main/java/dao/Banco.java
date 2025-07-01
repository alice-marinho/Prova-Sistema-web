package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Order;
import model.Salesman;

public class Banco {

    public static Connection getConnection() {
        Connection con = null;
        try {
            String dbDriver = "org.postgresql.Driver";
            String dbURL = "jdbc:postgresql://localhost:5432/servlet-prova";
            String dbUsername = "postgres";
            String dbPassword = "root";
            Class.forName(dbDriver);

            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // ---------- VENDEDORES ----------

    public static int adicionaVendedor(Salesman vendedor) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO salesman (name, city, commission) VALUES (?, ?, ?)"
            );
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getCidade());
            ps.setDouble(3, vendedor.getComissao());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    
    public static int atualizaVendedor(Salesman s) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE salesman SET name=?, city=?, commission=? WHERE salesman_id=?"
            );
            ps.setString(1, s.getNome());
            ps.setString(2, s.getCidade());
            ps.setDouble(3, s.getComissao());
            ps.setInt(4, s.getId());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deletaVendedor(int id) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM salesman WHERE salesman_id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Salesman buscaVendedorPeloId(int id) {
        Salesman s = new Salesman();
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM salesman WHERE salesman_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setId(rs.getInt("salesman_id"));
                s.setNome(rs.getString("name"));
                s.setCidade(rs.getString("city"));
                s.setComissao(rs.getDouble("commission"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    public static List<Salesman> buscaTodosVendedores() {
        List<Salesman> lista = new ArrayList<>();
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM salesman");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Salesman s = new Salesman();
                s.setId(rs.getInt("salesman_id"));
                s.setNome(rs.getString("name"));
                s.setCidade(rs.getString("city"));
                s.setComissao(rs.getDouble("commission"));
                lista.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }



    // ---------- CLIENTES ----------

    public static int adicionaCliente(Customer cliente) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO customer (cust_name, city, grade, salesman_id) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCidade());
            ps.setInt(3, cliente.getGrade());
            ps.setInt(4, cliente.getSalesmanId());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    
    public static int atualizaCliente(Customer c) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE customer SET cust_name=?, city=?, grade=?, salesman_id=? WHERE customer_id=?"
            );
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCidade());
            ps.setInt(3, c.getGrade());
            ps.setInt(4, c.getSalesmanId());
            ps.setInt(5, c.getId());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public static int deletaCliente(int id) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE customer_id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static Customer buscaClientePeloId(int id) {
        Customer c = new Customer();
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE customer_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("customer_id"));
                c.setNome(rs.getString("cust_name"));
                c.setCidade(rs.getString("city"));
                c.setGrade(rs.getInt("grade"));
                c.setSalesmanId(rs.getInt("salesman_id"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    public static List<Customer> buscaTodosClientes() {
        List<Customer> lista = new ArrayList<>();
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("customer_id"));
                c.setNome(rs.getString("cust_name"));
                c.setCidade(rs.getString("city"));
                c.setGrade(rs.getInt("grade"));
                c.setSalesmanId(rs.getInt("salesman_id"));
                lista.add(c);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public static boolean vendedorExiste(int id) {
        boolean existe = false;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT 1 FROM salesman WHERE salesman_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            existe = rs.next(); // retorna true se encontrou algo
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;
    }






    // ---------- ORDENS/VENDAS ----------

    public static int adicionaVenda(Order venda) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO orders (purch_amt, ord_date, customer_id, salesman_id) VALUES ( ?, ?, ?, ?)"
            );
            ps.setDouble(1, venda.getPurchAmt());
            ps.setDate(2, venda.getOrdDate());
            ps.setInt(3, venda.getCustomerId());
            ps.setInt(4, venda.getSalesmanId());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    
    public static int atualizaVenda(Order o) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE orders SET purch_amt=?, ord_date=?, customer_id=?, salesman_id=? WHERE ord_no=?"
            );
            ps.setDouble(1, o.getPurchAmt());
            ps.setDate(2, o.getOrdDate());
            ps.setInt(3, o.getCustomerId());
            ps.setInt(4, o.getSalesmanId());
            ps.setInt(5, o.getOrdNo());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deletaVenda(int id) {
        int status = 0;
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM orders WHERE ord_no=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Order buscaVendaPeloId(int id) {
        Order o = new Order();
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orders WHERE ord_no=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                o.setOrdNo(rs.getInt("ord_no"));
                o.setPurchAmt(rs.getDouble("purch_amt"));
                o.setOrdDate(rs.getDate("ord_date"));
                o.setCustomerId(rs.getInt("customer_id"));
                o.setSalesmanId(rs.getInt("salesman_id"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
    
    public static List<Order> buscaTodasVendas() {
        List<Order> lista = new ArrayList<>();
        try {
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orders");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrdNo(rs.getInt("ord_no"));
                o.setPurchAmt(rs.getDouble("purch_amt"));
                o.setOrdDate(rs.getDate("ord_date"));
                o.setCustomerId(rs.getInt("customer_id"));
                o.setSalesmanId(rs.getInt("salesman_id"));
                lista.add(o);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }



}
