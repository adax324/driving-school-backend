<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Szkoła jazdy | Lista Kursantów</title>
    <%@include file="../../dynamic/baseCss.jspf" %>
    <!-- DataTables -->
    <link rel="stylesheet" href='<c:url value="/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css"/>'>
    <link rel="stylesheet"
          href='<c:url value="/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css"/>'>
    <link rel="stylesheet"
          href='<c:url value="/resources/plugins/datatables-buttons/css/buttons.bootstrap4.min.css" />'>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
<%@include file="../../dynamic/Sidebar.jspf" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
<!-- Content Header (Page header) -->
<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1>Kursanci</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="#">Strona główna</a></li>
                    <li class="breadcrumb-item active">Lista kurstantów</li>
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

<!-- /.card -->

<div class="card">
<div class="card-header">
    <h3 class="card-title">Lista kurstanów </h3>
</div>
<!-- /.card-header -->


<div class="card-body">
<div class="row">
    <div class=" mb-2 col-sm-2 col-md-2">
        <a href='<c:url value="/students/addStudent"/>' class="btn btn-success">+ Dodaj kursanta</a>
    </div>
</div>

<table id="example1" class="table table-bordered table-striped">
<thead>
<tr>
    <th>Imię</th>
    <th>Nazwisko</th>
    <th>Data urodzenia</th>
    <th>Email</th>
    <th>Numer telefonu</th>
    <th>Instruktor</th>
    <th>Pozostałe godziny</th>
    <th>Gotowy do egzaminu</th>
    <th>Oddział</th>
    <th>Edycja</th>
</tr>
</thead>
<tbody>

<c:forEach items="${students}" var="student">

    <tr>
    <td>${student.firstName}</td>
    <td>${student.lastName}</td>
    <td>${student.birthDate}</td>
    <td>${student.email}</td>
    <td>${student.phoneNumber}</td>
<%--    <td><a href='<c:url value="${title.birthDate}"/>' class="btn btn-info btn-circle">
    <i class="fas fa-info-circle"></i>
    </a></td>
    <td>${title.start}</td>
    <td><a href="#" role="button" class="btn btn-success btn-circle" data-toggle="modal" data-target="#umiejetnosci"><i class="fas
    fa-check"></i></a></td>--%>

    <td><a href='<c:url value="/editStudent/${student.id}"/>'
    class="btn-right btn btn-primary" role="button">Edytuj</a>
    </td>
    </tr>
</c:forEach>
</tbody>
</tbody>
    <tfoot>
    <tr>
    <th>Imię</th>
    <th>Nazwisko</th>
    <th>Data urodzenia</th>
    <th>Email</th>
    <th>Numer telefonu</th>
    <th>Instruktor</th>
    <th>Pozostałe godziny</th>
    <th>Gotowy do egzaminu</th>
    <th>Oddział</th>
    <th>Edycja</th>
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
    <%@include file="../../dynamic/footer.jspf" %>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
    </div>
    <!-- jQuery -->
    <script src='<c:url value="/resources/plugins/jquery/jquery.min.js"/>'></script>
    <!-- Bootstrap 4 -->
    <script src='<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>'></script>
    <!-- bs-custom-file-input -->
    <script src='<c:url value="/resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"/>'></script>
    <!-- AdminLTE App -->
    <script src='<c:url value="/resources/dist/js/adminlte.min.js"/>'></script>
    <script>
    $(function () {
    $("#example1").DataTable({
    "responsive": true, "lengthChange": false, "autoWidth": false,
    "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
    "paging": true,
    "lengthChange": false,
    "searching": false,
    "ordering": true,
    "info": true,
    "autoWidth": false,
    "responsive": true,
    });
    });
    </script>
    </body>
    </html>
