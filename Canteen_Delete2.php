<?php
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);
$itemid=$_POST["itemid"];
$stmt="DELETE FROM `item` WHERE itemid like '$itemid';";
$result=mysqli_query($conn ,$stmt);
echo "Delete Successful";
?>
