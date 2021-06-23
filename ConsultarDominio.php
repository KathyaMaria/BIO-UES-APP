<?php
  
$hostname_localhost ="127.0.0.1";
$database_localhost ="laravel4";
$username_localhost ="root";
$password_localhost ="";

$json=array();

	if(isset($_GET["nombreDominio"])){
		$dominio=$_GET["nombreDominio"];
				
		$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

		$consulta="select * from dominios";
		$resultado=mysqli_query($conexion,$consulta);
			
		if($registro=mysqli_fetch_array($resultado)){
			$json['dominios'][]=$registro;
		//	echo $registro['id'].' - '.$registro['nombre'].' - '.$registro['profesion'].'<br/>';
		}else{
			$resultar["nombreDominio"]=0;
			$json['dominios'][]=$resultar;
		}
		
		mysqli_close($conexion);
		echo json_encode($json);
	}
	else{
		$resultar["success"]=0;
		$resultar["message"]='Ws no Retorna';
		$json['dominios'][]=$resultar;
		echo json_encode($json);
	}
 ?>