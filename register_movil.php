<?php

require_once("conexion.php");
	
	class SignupUser {
		
		private $db;
        private $conexion;
		
		function __construct() {
			$this -> db = new Conectar();
			$this -> conexion = $this->db->conexion();
        }
        
		public function does_user_exist($nombres,$email,$password)
		{
            $query = "Select * from users where email='$email'";
            $result = $this -> conexion->prepare($query);
            $result->execute();
            
			if($result->rowCount() == 1){
              
				$json['error'] = 'Ya existe un usuario con '.$email;
				echo json_encode($json);
			}else{
				//registro
                $query = "insert into users (name, email, password) values (?,?,?)";
				$inserted = $this->conexion->prepare($query);
				
				$inserted->bindParam(1, $name, PDO::PARAM_STR); 
				$inserted->bindParam(2, $email, PDO::PARAM_STR);
				$inserted->bindParam(3, $password, PDO::PARAM_STR);
			
				if($inserted->execute()){
					$json['success'] = 'Cuenta creada';

					$query = "SELECT name,email,password FROM users WHERE email = ?";

					try {
						// Preparar sentencia
						$comando = $this->conexion->prepare($query);
						// Ejecutar sentencia preparada
						$comando->execute(array($email));
						// Capturar primera fila del resultado
						$row = $comando->fetch(PDO::FETCH_ASSOC);
					
						$json['users'][]=$row;
					
					} catch (PDOException $e) {
						// Aquí puedes clasificar el error dependiendo de la excepción
						// para presentarlo en la respuesta Json
						return -1;
					}

				}else{
					$json['error'] = 'Se produjo un error';
				}
				echo json_encode($json);
			}    
			
		}
		
	}
	
	$signupUser = new SignupUser();
	if(isset($_POST['name'],$_POST['email'],$_POST['password'])) {
		$nombres = $_POST['name'];
		$email = $_POST['email'];
		$password = $_POST['password'];
		
				
	       
		if(!empty($name) && !empty($email) && !empty($password)){
			
			$encrypted_password = md5($password);
			$signupUser-> does_user_exist($name,$email,$password);
			
		}else{
			echo json_encode("debe escribir todos los campos");
		}
		
	}
?>