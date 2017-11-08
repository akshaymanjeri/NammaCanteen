<?php
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);

$date=date('Y-m-d H:i:s');
$sql="SELECT phoneno FROM phndummy";
$res=mysqli_query($conn ,$sql);
$rs=mysqli_fetch_array($res);
$phno=$rs['phoneno'];
$total=$_POST['total'];
$stmt="INSERT INTO `forder`(orderon, phoneno, OrderAmt) VALUES ('$date','$phno','$total');";
$result=mysqli_query($conn ,$stmt);
$orderid=mysqli_insert_id($conn);
$json=$_POST["json"];
$string=json_decode($json,true);
foreach($string as $str){
    $itemname=$str['itemname'];
    $quantity=$str['quantity'];
    $cost=$str['cost'];
    $sql2="SELECT itemid FROM item WHERE itemname LIKE '$itemname';";
    $res2=mysqli_query($conn ,$sql2);
    $rs2=mysqli_fetch_array($res2);
    $itemid=$rs2['itemid'];
    $stmt3="INSERT INTO `sales`(soldon, quantity,Total,itemid,orderid) VALUES ('$date','$quantity','$cost','$itemid','$orderid');";
    $result3=mysqli_query($conn ,$stmt3);
}
echo "Order Submitted";
?>
