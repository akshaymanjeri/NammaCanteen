<?php  
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);

//creating a query
$stmt = "SELECT ordeid,orderon,phoneno,OrderAmt FROM forder,phndummy WHERE phoneno.phndummy LIKE phoneno.forder;";
$query=mysqli_query($conn,$stmt); 
if($query)
{
while($row=mysqli_fetch_array($query))
{
$flag[]=$row;
}
print(json_encode($flag));
}
?>
