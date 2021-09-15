<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>DriverGoes</title>
  <%@include file="../../dynamic/baseCss.jspf"%>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
 <%@include file="../../dynamic/Sidebar.jspf"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-2">
            <h1>Nowe Zadanie</h1>
          </div>
          <div class="col-sm-10">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">General Form</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-xl-6 col-md-6 mb-6">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header py-3">
                <h3 class="card-title">Dane:</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
       
            <div class="card-body">
            <div class="form-group row">
                     <div class="col-12">
                     <label>Kursant</label>
                      <select class="form-control"></select>
                    </div>
                </div>
                <div class="form-group row">
                  <div class="col-12">
                  <label >Rodzaj zajęć</label>
                  <select class="form-control">
                    <option>Zajęcia teoretyczne</option>
                    <option>Zajęcia praktyczne</option>
                    <option>Egzamin wewnętrzny teoretyczny</option>
                    <option>Egzamin wewnętrzny praktyczny</option>
                    <option>Zadanie domowe</option>
                  </select>
                </div>
                </div>
                <div class="form-group row">
                  <div class="col-12">
                    
                    <label>Termin</label>
                    <input type="date" class="form-control">
                    
                  </div>

                </div>
                <div class="form-group row">
                  <div class="col-12">
                    
                    <label>Godzina</label>
                    <input type="time" class="form-control">
                    
                  </div>

                </div>
                
              </div>
            
              </div>
                </div>
            <div class="col-xl-6 col-md-6 mb-6">
            <div class="card card-primary">
              <div class="card-header py-3">
                <h3 class="card-title">Dane szkoły</h3>
              </div>
            
             <div class="card-body">

            <div class="form-group row">

                    <div class="col-sm-12">
                      <!-- select -->
                      <div class="form-group">
                        <label>Miasto</label>
                        <select class="form-control">
                          <option>Poznań</option>
                          <option>Wrocław</option>
                          <option>Gdańsk</option>
                          <option>Lublin</option>

                        </select>
                      </div>
                    </div>
                 </div>
                 <div class="form-group row">
                <div class="col-sm-12">
                      <div class="form-group">
                        <label>Oddział</label>
                        <select class="form-control">
                          <option>POZ</option>
                          <option>WRO</option>
                          <option>GDN</option>
                          <option>LUB</option>
                        </select>
                      </div>
                    </div>
                 </div>
                 <div class="form-group row">
                <div class="col-sm-12">
                      <div class="form-group">
                        <label>Instruktor</label>
                        <select class="form-control">
                          <option>Janusz Januszowski</option>
                          <option>Kolo Kolutek</option>
                          <option>Wariacik Szybki</option>
                          <option>Nie Wiem Czy To Dobry Pomysł</option>
                        </select>
                      </div>
                    </div>
                 </div>
              </div>    
              </div>
               
              <!-- /.card-body -->
            </div>
           
            </div>
     
        <input class="btn btn-success pull-left" type="submit" value="Zapisz zmiany" id="searchButton">
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">
                        Anuluj
                    </button>
                    <!-- The Modal -->
                    <div class="modal" id="myModal">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Czy na pewno anulować?</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>


                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Anuluj</button>
                                    <input type="submit" class="btn btn-danger pull-left" value="Tak"/>
                                </div>

                            </div>

                        </div>
                    </div>
      
        </div>
     
      </section>
    </div>

    <!-- /.content -->

  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.1.0
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src='<c:url value="/resources/plugins/jquery/jquery.min.js"/>'></script>
<!-- Bootstrap 4 -->
<script src='<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>'></script>
<!-- bs-custom-file-input -->
<script src='<c:url value="/resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"/>'></script>
<!-- AdminLTE App -->
<script src='<c:url value="/resources/dist/js/adminlte.min.js"/>'></script>

<!-- Page specific script -->
<script>
$(function () {
  bsCustomFileInput.init();
});
</script>
</body>
</html>
