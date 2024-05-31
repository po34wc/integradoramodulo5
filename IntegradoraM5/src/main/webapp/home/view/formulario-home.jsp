<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body onload = "formatearSaldo()">
	<div class="container">
		<div class="row">
			<div class="cold-md-12">
				<div class="mb-3">
					<h1>Nombre: ${sessionScope.nombreUsuario}</h1>
					<h1>Saldo Disponible: $ ${sessionScope.saldoDisponible}</h1>					
				</div>
				<div class="mb-3">
					<a href="/IntegradoraM5/depositar" class="btn btn-primary btn-lg">Depositar</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="/IntegradoraM5/retirar" class="btn btn-secondary btn-lg">Retirar</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>