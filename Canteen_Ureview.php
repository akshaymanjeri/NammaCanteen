<?php
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);

$sql="SELECT phoneno FROM phndummy";
$res=mysqli_query($conn ,$sql);
$rs=mysqli_fetch_array($res);
$phno=$rs['phoneno'];
$review=$_POST["review"];
$retype=$_POST["retype"];

$stmt="INSERT INTO `review`(phoneno,rtype,rev) VALUES ('$phno','good','$review');";
$result=mysqli_query($conn ,$stmt);
echo "Review Posted";
?>
