<?PHP
$hostname_localhost="localhost";
$database_localhost="bd_usuario";
$username_localhost="root";
$password_localhost="";

$conexion=mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

	$idInvestigacion = $_POST["idInvestigacion"];
	$lugarColecta = $_POST["lugarColecta"];
	$fechaColecta = $_POST["fechaColecta"];
	$horaColecta = $_POST["horaColecta"];
	$idUser = $_POST["idUser"];
	$latitud = $_POST["latitud"];
	$longitud = $_POST["longitud"];
	$tecnicaRecoleccion = $_POST["tecnicaRecoleccion"];
	$cantidad = $_POST["cantidad"];
	$tipoMuestra = $_POST["tipoMuestra"];
	$caracteristicas = $_POST["caracteristicas"];
	$peso = $_POST["peso"];
	$tamano= $_POST["tamano"];
	$habitat= $_POST["habitat"];
	$imagen = $_POST["imagen"];

	$path = "imagenes/$nombre.jpg";

	//$url = "http://$hostname_localhost/ejemploBDRemota/$path";
	$url = "imagenes/".$nombre.".jpg";

	file_put_contents($path,base64_decode($imagen));
	$bytesArchivo=file_get_contents($path);

	$sql="INSERT INTO especimens VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	$stm=$conexion->prepare($sql);
	$stm->bind_param('issssssssssssssss',$idInvestigacion,$lugarColecta,$fechaColecta,$horaColecta,$idUser,$latitud,$longitud,$tecnicaRecoleccion,$cantidad,$tipoMuestra,$caracteristicas,$peso,$tamano,$habitat,$bytesArchivo,$url);
		
	if($stm->execute()){
		echo "registra";
	}else{
		echo "noRegistra";
	}
	
	mysqli_close($conexion);
?>

