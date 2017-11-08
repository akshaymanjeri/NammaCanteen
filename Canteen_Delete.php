<?php
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);
$cid=$_POST["cid"];
$stmt="DELETE FROM `category` WHERE cid like '$cid';";
$result=mysqli_query($conn ,$stmt);
$stmt1="DELETE FROM `item` WHERE cid like '$cid';";
$result1=mysqli_query($conn ,$stmt1);
echo "Delete Successful";
?>
