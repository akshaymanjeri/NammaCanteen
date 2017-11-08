<?php
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);
$phone=$_POST["phoneno"];
$username=$_POST["username"];
$password=$_POST["password"];
$houseno=$_POST["houseno"];
$street=$_POST["street"];
$city=$_POST["city"];
$role="User";
$stmt="INSERT INTO `users` VALUES ('$phone', '$username','$password','$houseno','$street','$city','$role');";
$result=mysqli_query($conn ,$stmt);
echo "Registered successfully";
?>
