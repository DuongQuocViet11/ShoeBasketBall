<%@ page import="java.util.List" %>
<%@ page import="com.shoebasketball.shoebasketball.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Product> listProduct =  (List<Product>) request.getAttribute("listProduct");
%>
<html>
<jsp:include page="../includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>List Product</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/products/list">Product</a></li>
                            <li class="breadcrumb-item active">List Product</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">List Product</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Product ID</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Created At</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for(Product product: listProduct){
                                    %>
                                    <tr>
                                        <td><%=product.getProductId()%></td>
                                        <td><%=product.getName()%></td>
                                        <td><%=product.getCreate_At()%></td>
                                        <td>
                                            <a href="/admin/customers/detail?id=<%=product.getProductId()%>">Detail</a>&nbsp;&nbsp;
                                            <a href="/admin/customers/edit?id=<%=product.getProductId()%>">Edit</a>&nbsp;&nbsp;
                                            <a href="/admin/customers/delete?id=<%=product.getProductId()%>" onclick="return confirm('Are you sure?')">Delete</a>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Product ID</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Created At</th>
                                        <th>Action</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!--footer -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>
