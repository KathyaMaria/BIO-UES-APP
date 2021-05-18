<?php
$hostname='localhost';
$database='laravel4';
$username='root';
$password='';

$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_error){
	die("Lo Sentimos, el sitio web está experimentando problemas técnicos".$conexion->connect_error);
}else {
	echo "Successfully";
}
?>