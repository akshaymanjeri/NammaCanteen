<?php 
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);

//creating a query
$stmt = $conn->prepare("SELECT users.phoneno,username,hno,street,city FROM users,phndummy WHERE users.phoneno LIKE phndummy.phoneno;");

//executing the query 
$stmt->execute();
 
//binding results to the query 
$stmt->bind_result($phoneno, $username, $hno,$street, $city);
 
$profile = array(); 
 
//traversing through all the result 
while($stmt->fetch())
{
$temp = array();
$temp['phoneno'] = $phoneno;
$temp['username'] = $username; 
$temp['hno'] = $hno; 
$temp['street'] = $street; 
$temp['city'] = $city; 
array_push($profile, $temp);
}
 
//displaying the result in json format 
echo json_encode($profile);
?>
