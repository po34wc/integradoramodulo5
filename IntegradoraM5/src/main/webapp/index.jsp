<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ingreso</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="cold-md-12">
				<form action="/IntegradoraM5/login-formulario" method="post">
				  <div class="mb-3">
				    <label for="usuario" class="form-label">Usuario</label>
				    <input type=text class="form-control" name="usuario" id="usuario" aria-describedby="usuarioHelp">
				    <div id="usuarioHelp" class="form-text">Escriba su usuario.</div>
				  </div>
<!-- 				  <div class="mb-3">
				    <label for="clave" class="form-label">Clave</label>
				    <input type="text" class="form-control" name="clave" id="clave" aria-describedby="claveHelp">
				    <div id="claveHelp" class="form-text">Escriba su clave.</div>
				  </div> -->
				  <button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>