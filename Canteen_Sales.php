<?php  
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);

 
//creating a query
$stmt = $conn->prepare("SELECT salesid, soldon, quantity, total, itemname FROM item,sales WHERE item.itemid like sales.itemid;");
 
//executing the query 
$stmt->execute();
 
//binding results to the query 
$stmt->bind_result($salesid, $soldon, $quantity, $total, $itemname);
 
$sales = array(); 
 
//traversing through all the result 
while($stmt->fetch())
{
$temp = array();
$temp['salesid'] = $salesid; 
$temp['soldon'] = $soldon;  
$temp['quantity'] = $quantity; 
$temp['total'] = $total; 
$temp['itemname'] = $itemname;  
array_push($sales, $temp);
}
 
//displaying the result in json format 
echo json_encode($sales);
?>
