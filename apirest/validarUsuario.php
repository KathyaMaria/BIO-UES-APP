<?PHP
$hostname="localhost";
$database="laravel4";
$username="root";
$password="";
$json=array();
	if(isset($_GET["email"]) && isset($_GET["password"])){
		$email=$_GET['email'];
		$password=$_GET['password'];
		
		$conexion=mysqli_connect($hostname,$username,$password,$database);
		
		$consulta="SELECT email, password FROM usuars WHERE email= '{$email}' AND password = '{$password}'";
		$resultado=mysqli_query($conexion,$consulta);

		if($consulta){
		
			if($reg=mysqli_fetch_array($resultado)){
				$json['datos'][]=$reg;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		}



		else{
			$results["email"]='';
			$results["password"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
		
	}
	else{
		   	$results["email"]='';
			$results["password"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
?>