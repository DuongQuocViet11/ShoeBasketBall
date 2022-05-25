<%@ page import="com.shoebasketball.shoebasketball.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/14/2022
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="/admin/includes/navbar.jsp"></jsp:include>

    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="/admin/includes/sidebar.jsp"></jsp:include>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Detail Product</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/customers/list">Product Management</a></li>
                            <li class="breadcrumb-item active">Details</li>
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
                                <h3 class="card-title">Detail Product</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body table-responsive p-0">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th>Category ID</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><%=product.getCategoryId()%></td>
                                        <td><%=product.getName()%></td>
                                        <td><%=product.getDescription()%></td>
                                        <td><%=product.getDetail()%></td>
                                        <td>
                                            <img class="img-bordered" src="<%=product.getThumbnail()%>" alt="" width="150px">
                                        </td>
                                        <td><%=product.getPrice()%></td>
                                        <td><%=product.getUpdatedAt()%></td>
                                        <td><%=product.getUpdatedAt()%></td>
                                        <td><%=product.getStatus()%></td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Category ID</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                        <th>Status</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="/admin/includes/footer.jsp"></jsp:include>


    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<jsp:include page="/admin/includes/script.jsp"></jsp:include>
</body>
</html>
