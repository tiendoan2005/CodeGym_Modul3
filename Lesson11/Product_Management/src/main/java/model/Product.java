package model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private String nxb;

    public Product(int id, String name, int price, String description, String nxb) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.nxb = nxb;
    }

    public Product(String name, Integer price, String description, String nxb) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.nxb = nxb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }
}
// private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = req.getRequestDispatcher("/error-404.jsp");
//        } else {
//            this.customerService.remove(id);
//            try {
//                resp.sendRedirect("/customers");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String email = req.getParameter("email");
//        String address = req.getParameter("address");
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = req.getRequestDispatcher("/error-404.jsp");
//        } else {
//            customer.setName(name);
//            customer.setEmail(email);
//            customer.setAddress(address);
//            this.customerService.update(id, customer);
//            req.setAttribute("customer", customer);
//            req.setAttribute("message", "Customer information was updated");
//            dispatcher = req.getRequestDispatcher("customer/edit.jsp");
//        }
//        try {
//            dispatcher.forward(req, resp);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String email = req.getParameter("email");
//        String address = req.getParameter("address");
//        int id = (int) (Math.random() * 100000);
//
//        Customer customer = new Customer(id, name, email, address);
//        this.customerService.save(customer);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
//        req.setAttribute("message", "New customer was created");
//        try {
//            dispatcher.forward(req, resp);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
