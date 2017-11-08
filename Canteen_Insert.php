<?php
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);
$cid=$_POST["cid"];
$itemid=$_POST["itemid"];
$itemname=$_POST["itemname"];
$price=$_POST["price"];
$stmt="INSERT INTO `item`(`itemid`, `itemname`, `price`, `cid`) VALUES ('$itemid','$itemname','$price','$cid');";
$result=mysqli_query($conn ,$stmt);
echo "Insert Successful";
?>
