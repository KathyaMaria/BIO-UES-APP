<?PHP
$hostname_localhost ="localhost";
$database_localhost ="laravel4";
$username_localhost ="root";
$password_localhost ="";

$json=array();
				
		$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

		//$consulta="select id,nombreDominio from dominios";

		 /*$consulta="SELECT Ri.id, Ri.catRiesgo, esp.nomEspamen, esp.nomComEspamen,
						FROM riesgos Ri 
						INNER JOIN especie_amenazadas esp ON Ri.id = esp.idRiesgo"; */

		$consulta=$conexion->query("SELECT * FROM zonas z INNER JOIN municipios m  ON
			z.idMunicipio = m.id  INNER JOIN departamentos d ON m.idDepto = d.id");
		while ($row = $consulta->fetch_array()) {
			$json['zonas'][]=$row;
			//echo $row['nomComEspamen']."<br>".$row['catRiesgo']."<br><br>";
		}
 
		/*$resultado=mysqli_query($conexion,$consulta);
		
		while($registro=mysqli_fetch_array($resultado)){
			$json['especie_amenazadas'][]=$registro;
			//echo $registro['id'].' - '.$registro['nombre'].'<br/>';
		} */
		mysqli_close($conexion);
		echo json_encode($json);
?>
