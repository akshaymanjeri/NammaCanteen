<?php  
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);

 
//creating a query
$stmt = $conn->prepare("SELECT itemname, price FROM item;");
 
//executing the query 
$stmt->execute();
 
//binding results to the query 
$stmt->bind_result($itemname, $price);
 
$items = array(); 
 
//traversing through all the result 
while($stmt->fetch())
{
$temp = array();
$temp['itemname'] = $itemname; 
$temp['price'] = $price; 
array_push($items, $temp);
}
 
//displaying the result in json format 
echo json_encode($items);
?>
