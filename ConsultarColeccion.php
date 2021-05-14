<?php

require 'init.php';

$sql = "SELECT * FROM contacts_retro";

$result = mysqli_query($connection, $sql);
$response = array();

while($row = mysqli_fetch_array($result)){
    array_push($response, array('name'=>$row['name'], 'email'=>$row['email']));
}

echo json_encode($response);

mysqli_close($connection);


?>