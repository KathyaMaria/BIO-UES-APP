<?php
  
$servername = "127.0.0.1";
$username = "root";
$password = "";
$dbname = "laravel4";
// Creando la conexion
$conexion = new mysqli($servername, $username, $password, $dbname);
  $response = array();
 /* On below line we are checking if the body provided by user contains  this keys as id and nombreColeccion 
 Isn't necessary to include the id, if you do it, it will work too. 
 it could be either this: if($_POST['id'] && $_POST['nombreColeccion']), or just how we have it below */ 
 if($_POST['nombreColeccion'] && $_POST['tipoColeccion']){
   /* if above parameters are present then we are extravting values  from it and storing it in new variables. */ 
    
     $nombreColeccion = $_POST['nombreColeccion'];
     $tipoColeccion= $_POST['tipoColeccion'];
      /* after that we are writing an sql query to  add this data to our database */
     $query = $conexion->prepare("INSERT INTO `coleccions`(`nombreColeccion`,`tipoColeccion`) VALUES (?,?)");
     $query->bind_param("ss",$nombreColeccion, $tipoColeccion);
   // on below line we are checking if our sql query is executed succesfully.
   if($query->execute() == TRUE){
        /* If the script is executed succesfully we are passing data to our response object with a success message. */
         $response['error'] = false;
         $response['message'] = "Coleccion agregado con éxito!";
     } else{
         // If we get any error we are passing error to our object.
         $response['error'] = true;
         $response['message'] = "Error\n ".$conexion->error;
     }
 } else{
     // this method is called when user do not enter sufficient parameters. 
     $response['error'] = true;
     $response['message'] = "Parametros Insuficientes";
 }
 // We are prinintg our response which we get. 
 echo json_encode($response);
 ?>