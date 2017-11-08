<?php
$mysql_host='localhost';
$mysql_user='id3044780_admin';
$mysql_password='admin';
$mysql_dbname='id3044780_canteen';

$conn=mysqli_connect($mysql_host,$mysql_user,$mysql_password,$mysql_dbname);
$username=$_POST["username"];
$pass=$_POST["password"];
$role='Admin';
$mysql_qry="SELECT * FROM users WHERE phoneno like '$username' and pswd like '$pass' and role like '$role';";
$result=mysqli_query($conn ,$mysql_qry);
if(mysqli_num_rows($result) > 0) {
echo "Admin Login successful";
}
else {
echo "Admin Login unsuccessful";
}
?>
