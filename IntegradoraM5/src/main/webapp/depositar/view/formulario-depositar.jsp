<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Formulario Depositar</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="cold-md-12">
				<form action="/IntegradoraM5/depositar" method="post">
				  <div class="mb-3">
				    <label for="monto" class="form-label">Monto a depositar</label>
				    <input type=text class="form-control" name="monto" id="monto" aria-describedby="montoHelp">
				    <div id="montoHelp" class="form-text">Ingrese el monto a depositar.</div>
				  </div>
				  <button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>