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

		$consulta=$conexion->query("SELECT nombreEspecie, nombreGenero, nombreFamilia , nombreOrden, nombreClase, nombreFilum, nombreReino, nombreDominio FROM 
			especies e JOIN generos g ON  e.idGenero = g.id 
					   JOIN familias f ON g.idFamilia = f.id
					   JOIN ordens o ON f.idOrden = o.id
					   JOIN clases c ON o.idClase = c.id
					   JOIN filums fi ON c.idFilum = fi.id
					   JOIN reinos r ON fi.idReino = r.id
					   JOIN dominios d ON r.idDominio = d.id");
		while ($row = $consulta->fetch_array()) {
			$json['especies'][]=$row;
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
