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
          <div class="col-sm-6">
            <h1>${Imię i Nazwisko kursanta}</h1>
          </div>
          <div class="col-sm-6">
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
                <h3 class="card-title">Dane kursanta</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
                <form method="post" action='<c:url value="/studentList/${students.id}"/>'>
            <div class="card-body">
            <div class="form-group row">
                     <div class="col-12">
                     <label for="exampleFirstName" class="col-form-label">Imię</label>
                         <input class="form-control" type="text" name="firstName"
                                value="${students.firstName}">
                    </div>
                </div>
                <div class="form-group row">
            <div class="col-12">
                   <label for="exampleSecondName" class="col-form-label">Nazwisko</label>
                <input class="form-control" type="text" name="firstName"
                       value="${students.lastName}">
                    </div>
                </div>
                <div class="form-group row">
            <div class="col-12">
                   <label for="exampleBirthDate" class="col-form-label">Data urodzenia</label>
                <input class="form-control" type="text" name="firstName"
                       value="${students.birthDate}">
                    </div>
                </div>
                <div class="form-group row">
            <div class="col-12">
                    <label for="exampleEmail" class="col-form-label">Email</label>
                <input class="form-control" type="text" name="firstName"
                       value="${students.email}">
                    </div>
                </div>
                <div class="form-group row">
            <div class="col-12">
                   <label for="examplePhone" class="col-form-label">Tel:</label>
                <input class="form-control" type="text" name="firstName"
                       value="${students.phoneNumber}">
                    </div>
                </div>
                                <div class="form-group row">
            <div class="col-12">
                   <label for="hoursEndCourse" class="col-form-label">Ilość pozostałych godzin:</label>
                    <input class="form-control form-control-sm" type="text" name="godziny" placeholder="Ilość pozostałych godzin...">
                    </div>
                </div>

            
            
                <div class="form-group row">
                    <div class="custom-control custom-switch custom-switch-off-danger custom-switch-on-success">
                      <input type="checkbox" class="custom-control-input" id="customSwitch3">
                      <label class="custom-control-label" for="customSwitch3">Czy kursant gotowy do egzaminu?</label>
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
                        <select class="form-control" disabled>
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
                        <select class="form-control" disabled>
                          <option>Janusz Januszowski</option>
                          <option>Kolo Kolutek</option>
                          <option>Wariacik Szybki</option>
                          <option>Nie Wiem Czy To Dobry Pomysł</option>
                        </select>
                      </div>
                    </div>
                 </div>
                         <div class="row">
          <div class="col-xl-12 col-md-12 mb-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Dane kursu</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th style="width: 10px">lp.</th>
                      <th>Nauka|Egzamin</th>
                      <th>Wykonano</th>
                      <th style="width: 40px">Wynik</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1.</td>
                      <td>Ilość wyjeżdzonych godzin</td>
                      <td>
                        <div class="progress progress-xs">
                          <div class="progress-bar progress-bar-warning" style="width: 55%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-warning">55%</span></td>
                    </tr>
                    <tr>
                      <td>2.</td>
                      <td>Egzamin wewnętrzny</td>
                      <td>
                        <div class="progress progress-xs">
                          <div class="progress-bar bg-warning" style="width: 70%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-warning">70%</span></td>
                    </tr>
                    <tr>
                      <td>3.</td>
                      <td>Egzamin teoretyczny</td>
                      <td>
                        <div class="progress progress-xs progress-striped active">
                          <div class="progress-bar bg-primary" style="width: 30%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-primary">30%</span></td>
                    </tr>
                    <tr>
                      <td>4.</td>
                      <td>Egzamin praktyczny</td>
                      <td>
                        <div class="progress progress-xs progress-striped active">
                          <div class="progress-bar bg-success" style="width: 0%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg">0%</span></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
            </div>
          </div>
              </div>    
              </div>
               
              <!-- /.card-body -->
            </div>
           
            </div>
     
        <input class="btn btn-success pull-left" type="submit" value="Zapisz zmiany" id="searchButton">
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">
                        Usuń
                    </button>
                    <!-- The Modal -->
                    <div class="modal" id="myModal">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Czy na pewno usunąć?</h4>
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
                    
                      <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModal">
                        Anuluj
                    </button>
                    <!-- The Modal -->
                    <div class="modal" id="myModal">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h3 class="modal-title">Czy na pewno anulować?</h3>
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
  <%@include file="../../dynamic/footer.jspf"%>

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

<!-- Page specific script -->
<script>
  $(function () {
    bsCustomFileInput.init();
  });
</script>
</body>
</html>
